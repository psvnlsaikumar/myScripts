import java.util.ArrayList;
import java.util.Arrays;
public class AreSame {

	public static boolean comp(int[] a, int[] b) {
		if(a == null || b == null){
			return false;
		}
		if(a.length != b.length) {
			return false;
		}
		ArrayList<Integer> sortA = new ArrayList<>();
		ArrayList<Integer> sortB = new ArrayList<>();
		ArrayList<Integer> toBeRemoved = new ArrayList<>();
		try{
		for(int e : a){
				sortA.add(e);
		}
	}catch(Exception ex){

	}
	try{
		for(int e: b){
					sortB.add(e);
				}
			}catch(Exception ex){

		}

		// Tests for any empty arraylists, returns false if any of them are empty.
		if(sortA.size() == 0 && sortB.size() == 0){
			return true;
		} else if(sortA.size() ==0 || sortB.size() ==0){
			return false;
		}

			for(Integer e: sortA){
			if(!sortB.contains(e * e)){
				return false;
			} else {
				sortB.remove(new Integer(e * e));
			}
			}
		System.out.println(sortA);
		System.out.println(sortB);
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(b));
    return true;
  }
}
