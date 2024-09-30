public class BinaryUtils {

    //Verificar se a string contém só 0 e 1.
    public static boolean isBinaryString(String s)
    {
        return s.matches("[01]+");
    }

    //Adicionar dois números binários representados em Strings
    public static String addBinaryStrings(String x, String y)
    {
    	//Completar o número menor com zeros.
        int maxLength = Math.max(x.length(), y.length());
        x = "0".repeat(maxLength - x.length()) + x;
        y = "0".repeat(maxLength - y.length()) + y;

        StringBuilder result = new StringBuilder();
        int carry = 0;

        for (int i = maxLength - 1; i >= 0; i--)
        {
            int sum = (x.charAt(i) - '0') + (y.charAt(i) - '0') + carry;
            result.append(sum % 2);
            carry = sum / 2;
        }

        if (carry != 0)
        {
            result.append(carry);
        }

        return trimLeadingZeros(result.reverse().toString());
    }

    //Subtração
    public static String subtractBinaryStrings(String x, String y)
    {
        int maxLength = Math.max(x.length(), y.length());
        x = "0".repeat(maxLength - x.length()) + x;
        y = "0".repeat(maxLength - y.length()) + y;

        StringBuilder result = new StringBuilder();
        int borrow = 0;

        for (int i = maxLength - 1; i >= 0; i--)
        {
            int diff = (x.charAt(i) - '0') - (y.charAt(i) - '0') - borrow;
            if (diff < 0) {
                diff += 2;
                borrow = 1;
            }
            else
            {
                borrow = 0;
            }
            result.append(diff);
        }

        return trimLeadingZeros(result.reverse().toString());
    }

    //Shift
    public static String shiftLeft(String x, int places)
    {
        return x + "0".repeat(places);
    }

    //Tirar zeros à esquerda que sobraram.
    private static String trimLeadingZeros(String s)
    {
        int i = 0;
        while (i < s.length() - 1 && s.charAt(i) == '0')
        {
            i++;
        }
        return s.substring(i);
    }
}