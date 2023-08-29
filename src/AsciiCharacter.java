public class AsciiCharacter {

    /**
     * converts a character to an 7 bit binaryString
     * @param character char(Ascii character) value
     * @return 7 bit binary string
     */
    public static String toSevenDigitBinaryString(char character) {
        return String.format("%7s", Integer.toBinaryString(character)).replace(" ", "0");
    }
}
