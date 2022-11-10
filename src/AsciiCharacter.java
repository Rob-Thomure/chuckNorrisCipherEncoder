public class AsciiCharacter {
    char character;

    public AsciiCharacter(char character) {
        this.character = character;
    }

    public String parseBinaryString() {
        return String.format("%7s", Integer.toBinaryString(character)).replace(" ", "0");
    }

}
