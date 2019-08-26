package w01.cp01;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

class FriendShip{
	int from;
	int to;
	int time;
	public FriendShip(int from, int to, int time) {
		super();
		this.from = from;
		this.to = to;
		this.time = time;
	}
}

public class SocialNetwork{
	List<FriendShip> friendshipList = new ArrayList<>();
	int [] numbers;
	int [] sizes;
	int numberOfParents;
	
	//assume that friendship ordered by timestamp
	public SocialNetwork(int N, String file) throws IOException{
		Files.lines(Paths.get(file)).map(createObj()).sorted((f1,f2)->Integer.compare(f1.time, f2.time)).forEach(friendshipList::add);
		numbers = new int[N];
		sizes = new int[N];
		numberOfParents = N;
		
		for(int i=0;i<N;i++){
			numbers[i] = i;
			sizes[i] = 1;
		}
	}
	
	private Function<String,FriendShip> createObj() {
		return s->{
			String[] temp = s.split(" ");
			return new FriendShip(Integer.valueOf(temp[0]),Integer.valueOf(temp[1]), Integer.valueOf(temp[2]));
		};
	}

	public int findEarlistTime(){
		for(FriendShip f: friendshipList){
			int from = f.from;
			int to = f.to;
			int time = f.time;
			
			numberOfParents = union(from,to);
			if(numberOfParents==1){
				return time;
			}
		}
		return -1;
	}
	
	public int union(int from, int to){
		int i = findParent(from);
		int j = findParent(to);
		
		if(i!=j){
			if(sizes[i]>sizes[j]){
				numbers[j] = i;
				sizes[i] += sizes[j];
			}else{
				numbers[i] = j;
				sizes[j] += sizes[i];
			}
			numberOfParents--;
		}
		return numberOfParents;
	}

	public int findParent(int from) {
		int i = numbers[from];
		while(i!=from) {
			i = from;
			from = numbers[i];
		}
		return i;
	}
	
	public static void main(String[] args) throws IOException {
		String file = "C:\\Users\\abdullah.ilhanli\\Documents\\data\\friendship.txt";
		
		SocialNetwork sn = new SocialNetwork(8, file);
		System.out.println(sn.findEarlistTime());
	}
}