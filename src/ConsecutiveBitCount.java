public class ConsecutiveBitCount {
    private final char bit;
    private int count;

    public ConsecutiveBitCount(char bit) {
        this.bit = bit;
        this.count = 1;
    }

    public void addCount() {
        count++;
    }

    public char getBit() {
        return bit;
    }

    public int getCount() {
        return count;
    }

    @Override
    public String toString() {
        return "BitCount{" +
                "bit=" + bit +
                ", count=" + count +
                '}';
    }
}
