/**
 * Class for translating hexadecimal numbers to decimal
 */
class HexToDec {

    static Long get(String input){
        if (input.matches("[0-9A-F]+")){
            return Long.parseLong(input, 16);
        } else {
            throw new IllegalArgumentException("Input string must be parseable hex-number.");
        }
    }

}
