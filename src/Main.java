import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean exit = false;
        while (!exit) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please input operation (encode/decode/exit):");
            String operation = scanner.nextLine().toLowerCase();
            switch (operation) {
                case "encode":
                    System.out.println("Input string");
                    ChuckNorrisUnaryCode chuckNorrisUnaryCode = new ChuckNorrisUnaryCode(scanner.nextLine());
                    System.out.println("Encoded string:");
                    System.out.println(chuckNorrisUnaryCode.parseChuckNorrisUnaryCode());
                    System.out.println();
                    break;
                case "decode":
                    System.out.println("Input encoded string:");
                    String encodedMessage = scanner.nextLine();
                    if (ChuckNorrisUnaryCode.isValid(encodedMessage)) {
                        System.out.println("Decoded string:");
                        String binaryString = ChuckNorrisUnaryCode.toBinaryString(encodedMessage);
                        System.out.println(AsciiString.toDecryptedString(binaryString));
                    } else {
                        System.out.println("Encoded string is not valid.");
                    }
                    System.out.println();
                    break;
                case "exit":
                    exit = true;
                    System.out.println("Bye!");
                    break;
                default:
                    System.out.printf("There is no '%s' operation\n\n", operation);
                    break;
            }
        }
    }
}