package lambda;

import java.util.Arrays;
import java.util.OptionalInt;

import javax.security.auth.x500.X500Principal;

public class Stream2 {

	public static void main(String[] args) {
		int[] pole = {1,9,3,4,5,6,7,8,9};
		
		int[]npole = Arrays.stream(pole).filter(i-> i >= 5).map(i -> i - 5).toArray();
		
		boolean b = Arrays.stream(pole).allMatch(x -> x > 5);
		
//		Arrays.stream(pole).filter(x -> x > 5).findFirst().getAsInt(); // alebo 
		// ak je kolekcia tak kolekcia.stream()
		OptionalInt oInt = Arrays.stream(pole).filter(x -> x > 5).findFirst();
		if (oInt.isPresent()) {
			System.out.println(oInt.getAsInt());
		}else {
			System.out.println("taky prvok tam nie je");
		}
	}
	private static void printArray(int[] pole) {
		for (int i : pole) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

}
