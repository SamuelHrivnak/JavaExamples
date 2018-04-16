
public class TestClass {

	public static void main(String[] args) {
		long prva = System.currentTimeMillis();
		long druha= 0;
		long cislo = 5;
		for (int i = 0; i < 1000000000; i++) {
			cislo = cislo +i;
			for (int j = 0; j < 1000000000; j++) {
				cislo = cislo-j;
			}
		}
		druha = System.currentTimeMillis();
		prva = prva/1000;
		druha = druha/1000;
		
		System.out.println(druha-prva);

	}

}
