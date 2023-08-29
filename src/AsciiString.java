public class AsciiString {

    /**
     * converts a string of ascii characters into a string of 7 bit binary digits for each character
     * @param asciiString a string of ascii characters
     * @return string of binary digits
     */
    public static String toBinaryString(String asciiString) {
        StringBuilder binaryDigits = new StringBuilder();
        for (int i = 0; i < asciiString.length(); i++) {
            binaryDigits.append(AsciiCharacter.toSevenDigitBinaryString(asciiString.charAt(i)));
        }
        return binaryDigits.toString();
    }

    /**
     * converts a string of binary digits into a string of characters
     * @param binaryString a string of 7 bit binary characters
     * @return string of ascii characters
     */
    public static String parseAsciiString(String binaryString) {
        StringBuilder asciiCharacters = new StringBuilder();
        for (int i = 6; i < binaryString.length(); i += 7) {
            String binaryChar = binaryString.substring(i - 6, i + 1);
            asciiCharacters.append ((char) Integer.parseInt(binaryChar, 2));
        }
        return asciiCharacters.toString();
    }
}

