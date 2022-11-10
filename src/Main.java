import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input string:");
        char[] input = scanner.nextLine().toCharArray();
        System.out.println("\nThe result:");

        for (var character : input) {
            String binaryValue = String.format("%7s", Integer.toBinaryString(character)).replace(" ", "0");
            System.out.printf("%c = %s\n", character, binaryValue);
        }
    }
}