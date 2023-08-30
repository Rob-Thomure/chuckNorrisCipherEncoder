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
                    encode(scanner);
                    break;
                case "decode":
                    decode(scanner);
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

    private static void encode(Scanner scanner) {
        System.out.println("Input string");
        String asciiString = scanner.nextLine();
        System.out.println("Encoded string:");
        System.out.println(ChuckNorrisUnaryCode.parseChuckNorrisUnaryCode(asciiString));
        System.out.println();
    }

    private static void decode(Scanner scanner) {
        System.out.println("Input encoded string:");
        String chuckNorrisUnaryCode = scanner.nextLine();
        if (ChuckNorrisUnaryCode.isValid(chuckNorrisUnaryCode)) {
            System.out.println("Decoded string:");
            System.out.println(ChuckNorrisUnaryCode.toAsciiString(chuckNorrisUnaryCode));
        } else {
            System.out.println("Encoded string is not valid.");
        }
        System.out.println();
    }
}