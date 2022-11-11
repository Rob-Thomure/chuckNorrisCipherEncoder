public class AsciiCharacter {
    char character;

    public AsciiCharacter(char character) {
        this.character = character;
    }

    /**
     * converts a character to an 8 bit binaryString
     * @return 8 bit binary string
     */
    public String toBinaryString() {
        return String.format("%7s", Integer.toBinaryString(character)).replace(" ", "0");
    }

}
