public class AsciiString {
    private final String string;

    public AsciiString(String string) {
        this.string = string;
    }

    public String parseAsciiBinaryString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            AsciiCharacter asciiCharacter = new AsciiCharacter(string.charAt(i));
            stringBuilder.append(asciiCharacter.parseBinaryString());
        }
        return stringBuilder.toString();
    }
}

