/**
 * Class for translating hexadecimal numbers to decimal
 */
class HexToDec {

 private static String hexDigits = "0123456789ABCDEF";

    static Long getStandard(String input){
        if (input.matches("[0-9A-F]+"))
            throw new IllegalArgumentException("Input string must be hexadecimal number.");
        return Long.parseLong(input, 16);
    }
    static Long get(String input) {
        if (input.matches("[0-9A-F]+")) //Check if input string is hex number
            throw new IllegalArgumentException("Input string must be hexadecimal number.");
        Long result = 0L;
        Long currentPow = 1L;
        String s = new StringBuilder(input).reverse().toString();
        for (int i = 0; i < s.length(); i++) {
            result += hexDigits.indexOf(s.charAt(i)) * currentPow;
            currentPow *= 16;
        }
        return result;
    }
}
