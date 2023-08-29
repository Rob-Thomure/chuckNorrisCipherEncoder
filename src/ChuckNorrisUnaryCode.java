import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChuckNorrisUnaryCode {
    private final String asciiBinaryString;
    private int index;
    private char leadingBitValue;

    public ChuckNorrisUnaryCode(String string) {
        this.asciiBinaryString = AsciiString.toBinaryString(string);
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
     *
     * @param encodedMessage - a ChuckNorrisUnary coded message.
     * @return - checks the ChuckNorrisUnary code message and returns true
     * if includes valid characters, the first block of each sequence is 0 or 00,
     * the number of bocks is even, and the length of the binary bits is multiple 7
     */
    public static boolean isValid(String encodedMessage)  {
        String[] zeroBlocks = encodedMessage.split(" ");
        return isValidCharacters(encodedMessage) &&
                isValidFirstBlockSequences(zeroBlocks) &&
                isEvenNumberZeroBlocks(zeroBlocks) &&
                isSevenBitMultipleBits(zeroBlocks);
    }

    /**
     * Check whether message includes characters other than 0 or spaces.
     * @param encodedMessage - a ChuckNorrisUnary coded message.
     * @return - returns true if message doesn't include characters other than 0 or spaces
     */
    private static boolean isValidCharacters(String encodedMessage) {
        Pattern pattern = Pattern.compile("[^0+\s]");
        Matcher matcher = pattern.matcher(encodedMessage);
        return !matcher.find();
    }

    /**
     * Check if the first block of each sequence is not 0 or 00.
     * @param zeroBlocks - a String array block of 0 bits from ChuckNorris coded message.
     * @return - returns true if the first block in each pair in only includes 0 or 00
     */
    private static boolean isValidFirstBlockSequences(String[] zeroBlocks){
        for (int i = 1; i < zeroBlocks.length; i += 2) {
            if (!zeroBlocks[i - 1].matches("0{1,2}")) {
                return false;
            }
        }
        return true;
    }

    /**
     * Check if ChuckNorrisUnary coded message includes even number of 0 bit blocks
     * @param zeroBlocks - a String array block of 0 bits from ChuckNorris coded message.
     * @return - returns true if zeroBlocks array size is even.
     */
    private static boolean isEvenNumberZeroBlocks(String[] zeroBlocks) {
        return zeroBlocks.length % 2 == 0;
    }

    /**
     * check if the length of the decoded binary string is multiple of 7.
     * @param zeroBlocks - a String array block of 0 bits from ChuckNorris coded message.
     * @return -
     */
    private static boolean isSevenBitMultipleBits(String[] zeroBlocks) {
        int bitCount = 0;
        for (int i = 1; i < zeroBlocks.length; i += 2) {
            bitCount += zeroBlocks[i].length();
        }
        return bitCount % 7 == 0;
    }









    /**
     * converts a chuckNorrisUnaryCode string to a binary string
     * @param chuckNorrisUnaryCode -
     */
    private static String toBinaryString(String chuckNorrisUnaryCode) {
        String[] blocks = chuckNorrisUnaryCode.split(" ");
        StringBuilder binaryString = new StringBuilder();
        for (int i = 1; i < blocks.length; i+=2) {
            String bit = blocks[i - 1].equals("0")  ? "1" : "0";
            binaryString.append(bit.repeat(blocks[i].length()));
        }
        return binaryString.toString();
    }

    /**
     * converts chuckNorrisUnary code into a string of ascii characters (decoded message)
     * @param chuckNorrisUnaryCode
     * @return String decoded message
     */
    public static String toAsciiString(String chuckNorrisUnaryCode) {
        String binaryString = toBinaryString(chuckNorrisUnaryCode);
        return AsciiString.parseAsciiString(binaryString);
    }
}
