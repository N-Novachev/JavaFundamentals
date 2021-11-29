package PreviousFinalExams.P01ProgrammingFundamentalsFinalExamRetake;
//On the first line of the input, you will receive the encrypted message. After that, until the "Decode" command is given, you will be receiving strings with
// instructions for different operations that need to be performed upon the concealed message to interpret it and reveal its true content. There are several types of instructions, split by '|'
//"Move {number of letters}":
//Moves the first n letters to the back of the string
//"Insert {index} {value}":
//Inserts the given value before the given index in the string
//"ChangeAll {substring} {replacement}":
//Changes all occurrences of the given substring with the replacement text
//Input / Constraints
//On the first line, you will receive a string with a message.
//On the following lines, you will be receiving commands, split by '|' .
//Output
//After the "Decode" command is received, print this message:
//"The decrypted message is: {message}"


import javax.management.StringValueExp;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Arrays;
import java.util.function.DoubleFunction;
import java.util.stream.Collectors;
import java.util.Collections;

public class P01TheImitationGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input=scanner.nextLine();
        List<String> encryptedMessage = new ArrayList<String>(Arrays.asList(input.split("")));

        while(!input.equals("Decode")){
            List<String> commandList = new ArrayList<String>(Arrays.asList(input.split("\\|")));
            if(commandList.get(0).equals("Move")){
                for (int i = 0; i < Integer.parseInt(commandList.get(1)) ; i++) {
                    encryptedMessage.add(encryptedMessage.get(0));
                    encryptedMessage.remove(0);
                }
            }
            else if(commandList.get(0).equals("Insert")){
                if((Integer.parseInt(commandList.get(1))> encryptedMessage.size())){
                    commandList.set(1, String.valueOf(encryptedMessage.size()));
                }
                encryptedMessage.add(Integer.parseInt(commandList.get(1)), commandList.get(2));
            }
            else if(commandList.get(0).equals("ChangeAll")){
                for (int i = 0; i < encryptedMessage.size(); i++) {
                    if(encryptedMessage.get(i).equals(commandList.get(1))){
                        encryptedMessage.add(i,commandList.get(2));
                        encryptedMessage.remove(i+1);
                    }
                }
            }
            input=scanner.nextLine();
        }
        System.out.printf("The decrypted message is: ");
        for(String answer:encryptedMessage){
            System.out.printf("%s",answer);
        }
    }
}
