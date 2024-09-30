public class Karatsuba {
    
    public static String multiply(String x, String y) {
        
    	//Verificar se as entradas são binários válidos (contém só 0 e 1)
        if (!BinaryUtils.isBinaryString(x) || !BinaryUtils.isBinaryString(y))
        {
            return "Erro: Strings inválidas. Ambas strings devem conter apenas '0' ou '1'.";
        }

        //Caso Base: quando os números forem de apenas um bit, realizar a multiplicação.
        if (x.length() == 1 && y.length() == 1)
        {
            return Integer.toString((x.charAt(0) - '0') * (y.charAt(0) - '0'));
        }

        // Ensure both numbers have the same length by padding with leading zeros
        int n = Math.max(x.length(), y.length());
        if (x.length() < n) x = "0".repeat(n - x.length()) + x;
        if (y.length() < n) y = "0".repeat(n - y.length()) + y;

        if (n % 2 != 0) n++;

        //Dividir x e y em duas metades.
        int half = n / 2;
        String a1 = x.substring(0, x.length() - half);
        String a2 = x.substring(x.length() - half);
        String b1 = y.substring(0, y.length() - half);
        String b2 = y.substring(y.length() - half);

        //Recusão do cálculo de Karatsuba para as 3 partes.
        String a1b1 = multiply(a1, b1);  // z1 = a1 * b1
        String a2b2 = multiply(a2, b2);  // z2 = a2 * b2
        String s3 = multiply(BinaryUtils.addBinaryStrings(a1, a2), BinaryUtils.addBinaryStrings(b1, b2));  //s3 = (a1 + a2) * (b1 + b2)

        //Resultado final: a1b1 * 2^(2*half) + (s3 - a1b1 - a2b2) * 2^half + a2b2
        String result = BinaryUtils.addBinaryStrings(
            BinaryUtils.addBinaryStrings(BinaryUtils.shiftLeft(a1b1, 2 * half), BinaryUtils.shiftLeft(BinaryUtils.subtractBinaryStrings(BinaryUtils.subtractBinaryStrings(s3, a1b1), a2b2), half)),
            a2b2
        );

        return result;
    }
}