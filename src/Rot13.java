/**
 * Implementation of the ROT13 encoder/decoder for the english alphabet
 */
class Rot13 {

    private static String decodeStr = "NOPQRSTUVWXYZABCDEFGHIJKLMnopqrstuvwxyzabcdefghijklm";
    private static String encodeStr = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    static String encode(String input){
        // Get a StringBuilder to build encoded string fast
        StringBuilder encoded = new StringBuilder();

        for (int i = 0; i < input.length(); ++i) {
            char current_char = input.charAt(i);

            if (encodeStr.indexOf(current_char) >= 0) {
                // get encoded letter for the initial letter
                encoded.append(decodeStr.charAt(encodeStr.indexOf(current_char)));
            } else {
                encoded.append(current_char);
            }
        }
        return encoded.toString();
    }

    /**
     Decode and encode will give the same result for the english alphabet
     */
    static String decode(String input){
        return encode(input);
    }
}
