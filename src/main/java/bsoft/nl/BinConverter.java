package bsoft.nl;

import java.util.Arrays;

/*
Convert binary string presentation to character string
input: sequence '010101001111'
output: string representation "asdf"
 */
public class BinConverter {

    public String convert(final String string) {
        String result = "";
        String binString = string;

        final int maxBits = 7;
        int index = 0;
        int i = 0;
        int maxLen = binString.length();

        while (maxLen - index > 0) {
            String convString = "";

            for (i = 0; (i < maxBits) && ((maxLen - index - i) > 0); i++) {
                convString += binString.charAt(index + i);
            }
            index += i;

            int charCode = Integer.parseInt(convString, 2);
            result += new Character((char) charCode).toString();
        }

        return result;
    }

    public String conv(final String string) {
        String input = string; // Binary input as String
        StringBuilder sb = new StringBuilder(); // Some place to store the chars
        final int maxBits = 8;
        Arrays.stream( // Create a Stream
                input.split("(?<=\\G.{7})") // Splits the input string into 8-char-sections (Since a char has 8 bits = 1 byte)
        ).forEach(s -> // Go through each 8-char-section...
                sb.append((char) Integer.parseInt(s, 2)) // ...and turn it into an int and then to a char
        );

        return sb.toString(); // Output text (t)
    }
}
