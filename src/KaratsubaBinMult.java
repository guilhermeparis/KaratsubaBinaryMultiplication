public class KaratsubaBinMult {
	
	public static void main(String[] args) {
		
		String x = args[0];
		String y = args[1];
		
		//Para testes sem usar o terminal.
//		String x = "110101010101";  //3.413 in decimal
//		String y = "101101010101011"; //23.211 in decimal
		//O resultado deve ser 100101110001100100111000111 (79.219.143)
		
		System.out.println(Karatsuba.multiply(x, y));
	}
}