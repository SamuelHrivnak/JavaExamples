package lambda;


public class Stream1 {

	public static void main(String[] args) {
		int[] pole = {1,2,3,4,5};
		printArray(pole);
		doWithArray(pole, i -> i*2);
		printArray(pole);
		doWithArray(pole, i -> i*i);
		printArray(pole);
	}
	
	
	private static void doWithArray(int[] pole, Function f) {
		for (int i = 0; i < pole.length; i++) {
			pole[i] = f.execute(pole[i]);
		}
	}
	
	private static void printArray(int[] pole) {
		for (int i : pole) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}
