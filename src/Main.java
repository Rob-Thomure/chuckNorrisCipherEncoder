import java.util.Scanner;

// stage 3
// if series of 1's then 1st of dual blocks = 0
// if series of 0's then 1st of dual blocks = 00
// second of dual blocks number of contiguous 0's is equal to number of contiguous similar digits in ascii input

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input encoded string:");
        String input = scanner.nextLine();
        System.out.println("\nThe result:");
        String binaryString = ChuckNorrisUnaryCode.toBinaryString(input);
        String decipheredString = AsciiString.toDecryptedString(binaryString);

        System.out.println(decipheredString);
    }

}