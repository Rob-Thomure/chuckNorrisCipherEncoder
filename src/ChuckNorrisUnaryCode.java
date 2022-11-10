public class ChuckNorrisUnaryCode {
    private final String asciiBinaryString;
    private int index;
    private char leadingBitValue;

    public ChuckNorrisUnaryCode(String string) {
        this.asciiBinaryString = new AsciiString(string).parseAsciiBinaryString();
    }

    public String parseChuckNorrisUnaryCode() {
        StringBuilder stringBuilder = new StringBuilder();
        this.index = 0;

        while (index < asciiBinaryString.length()) {
            stringBuilder.append(addFirstBlock());
            stringBuilder.append(addSecondBlock());
        }
        return stringBuilder.toString().trim();
    }

    private String addFirstBlock() {
        leadingBitValue = asciiBinaryString.charAt(index);
        if (leadingBitValue == '1') {
            return "0 ";
        } else {
            return "00 ";
        }
    }

    private String addSecondBlock() {
        boolean nextBitMatchesLeadingBit = true;
        int numMatchingLeadingBit = 1;

        while (index < asciiBinaryString.length() && nextBitMatchesLeadingBit) {
            if (++index < asciiBinaryString.length()) {
                char nextBitValue = asciiBinaryString.charAt(index);
                if (leadingBitValue == nextBitValue) {
                    numMatchingLeadingBit++;
                } else {
                    nextBitMatchesLeadingBit = false;
                }
            }
        }
        return "0".repeat(numMatchingLeadingBit) + " ";
    }
}
