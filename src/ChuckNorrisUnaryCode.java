public class ChuckNorrisUnaryCode {
    private final String asciiBinaryString;
    private int index;
    private char leadingBitValue;

    public ChuckNorrisUnaryCode(String string) {
        this.asciiBinaryString = new AsciiString(string).parseAsciiBinaryString();
    }

    /**
     * @return - ciphered chuckNorrisUnaryCode string
     */
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

    /**
     * converts a chuckNorrisUnaryCode string to a binary string
     * @param chuckNorrisUnaryCode -
     */
    public static String toBinaryString(String chuckNorrisUnaryCode) {
        String[] blocks = chuckNorrisUnaryCode.split(" ");
        StringBuilder binaryString = new StringBuilder();
        for (int i = 1; i < blocks.length; i+=2) {
            String bit = blocks[i - 1].equals("0")  ? "1" : "0";
            binaryString.append(bit.repeat(blocks[i].length()));
        }
        return binaryString.toString();
    }
}
