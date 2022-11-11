public class AsciiString {
    private final String string;

    public AsciiString(String string) {
        this.string = string;
    }

    /**
     * converts a string into a string of 8 bit binary characters
     * @return string of 8 bit binary characters
     */
    public String parseAsciiBinaryString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            AsciiCharacter asciiCharacter = new AsciiCharacter(string.charAt(i));
            stringBuilder.append(asciiCharacter.toBinaryString());
        }
        return stringBuilder.toString();
    }

    /**
     * converts a binary string to a deciphered character string
     * @param binaryString a string of 7 bit binary characters
     */
    public static String toDecryptedString(String binaryString) {
        StringBuilder decipheredString = new StringBuilder();
        for (int i = 6; i < binaryString.length(); i += 7) {
            String binaryChar = binaryString.substring(i - 6, i + 1);
            decipheredString.append ((char) Integer.parseInt(binaryChar, 2));
        }
        return decipheredString.toString();
    }

}

