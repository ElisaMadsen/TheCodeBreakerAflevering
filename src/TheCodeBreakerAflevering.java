import java.util.Locale;
import java.util.Scanner;

public class TheCodeBreakerAflevering {

    //Methods
    static String alphabet = "abcdefghijklmnopqrstuvwxyzæøå";

    public static String numberCypherEncoder(String input) {
        String encodedString = "";

        for (int i = 0; i < input.length(); i++) {
            char inputChar = input.charAt(i);
            int charAtIndex = alphabet.indexOf(inputChar) + 1;
            encodedString = encodedString + charAtIndex + ";";
        }
        return encodedString;
    }

    public static String numberCypherDecoder(String[] numberInput) {
        String decodedString = "";

        for (int i = 0; i < numberInput.length; i++) {
            String indexAsAString = numberInput[i];
            int stringToInt = Integer.parseInt(indexAsAString) - 1;

            char indexToCharacter = alphabet.charAt(stringToInt);

            decodedString = decodedString + indexToCharacter++;

        }

        return decodedString;
    }

    //Greatly inspired by "Crypto: Caesar Cipher explained" on youtube
    public static String ceasarEncoder(String nonCodedString, int shift) {
        nonCodedString = nonCodedString.toLowerCase(Locale.ROOT);
        String codedString = "";
        for (int i = 0; i < nonCodedString.length(); i++) {
            int currentIndex = alphabet.indexOf(nonCodedString.charAt(i));
            int newIndex = (currentIndex + shift) % 29;
            char newChar = alphabet.charAt(newIndex);
            codedString = codedString + newChar;
        }
        return codedString;
    }

    //Greatly inspired by "Crypto: Caesar Cipher explained" on youtube
    public static String ceasarDecoder(String codedString, int shift) {
        codedString = codedString.toLowerCase(Locale.ROOT);
        String nonCodedString = "";
        for (int i = 0; i < codedString.length(); i++) {
            int currentIndex = alphabet.indexOf(codedString.charAt(i));
            int newIndex = (currentIndex - shift) % 29;
            if (newIndex < 0) {
                newIndex = alphabet.length() + newIndex;
            }
            char newChar = alphabet.charAt(newIndex);
            nonCodedString = nonCodedString + newChar;
        }
        return nonCodedString;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("----------------------------------------------------------------------------------------");
        System.out.println("Welcome to The Code Breaker! 🔓");
        System.out.println("----------------------------------------------------------------------------------------\n");

        //Number Cypher Encoder
        System.out.println("--------------------------------------");
        System.out.println("****Number Cypher Encoder****");
        System.out.println("--------------------------------------\n");

        //String from user
        System.out.println("First, type a word, then I will convert all characters to numbers!");
        String userInputEncode = scanner.next();
        userInputEncode = userInputEncode.toLowerCase(Locale.ROOT);

        //Encode string
        String wordEncoded = numberCypherEncoder(userInputEncode);
        String cypherEncoderResult = ("Nice! " + userInputEncode + " is " + wordEncoded + " in numbers!\n");
        System.out.println(cypherEncoderResult);


        //Number Cypher Decoder
        System.out.println("--------------------------------------");
        System.out.println("****Number Cypher Decoder****");
        System.out.println("--------------------------------------\n");

        System.out.println("Now let's take your encoded word and decode it again!");
        System.out.println("You typed " + userInputEncode + " which encoded to " + wordEncoded + ". That decodes to: ");

        //Decoded String to numbers
        String [] userInputDecodeArray = wordEncoded.split(";");
        String decodedWord = numberCypherDecoder(userInputDecodeArray);
        System.out.println(decodedWord + "\n");


        //Ceaser Encoder
        System.out.println("--------------------------------------");
        System.out.println("****Ceasar Encoder****");
        System.out.println("--------------------------------------\n");

        //String from user
        System.out.println("Let's try something else..\nFirst enter your word:");
        String ceasarEncoderInputString = scanner.next();

        //Shift from user
        System.out.println("Now enter the amount of times you want your word to be shifted:");
        int ceasarEncoderInputShift = scanner.nextInt();

        //Encoded string
        String encodedWord = ceasarEncoder(ceasarEncoderInputString, ceasarEncoderInputShift);
        System.out.println("Your encoded word is " + encodedWord + "!\n");


        //Ceaser Decoder
        System.out.println("--------------------------------------");
        System.out.println("****Ceasar Decoder****");
        System.out.println("--------------------------------------\n");

        System.out.println("Lastly we're gonna decode your word again!");


        //Decoded string
        System.out.println("The decoded word is --> " + ceasarDecoder(encodedWord, ceasarEncoderInputShift));

    }
}






