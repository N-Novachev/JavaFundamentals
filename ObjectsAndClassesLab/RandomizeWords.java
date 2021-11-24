package ObjectsAndClasses.ObjectsAndClassesLab;
//You are given a list of words on one line. Randomize their order and print each word on a separate line.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;
import java.util.Scanner;

public class RandomizeWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command=scanner.nextLine();
        List<String> commandList = new ArrayList<String>(Arrays.asList(command.split(" ")));
        Collections.shuffle(commandList);
        for(String output:commandList){
            System.out.println(output);
        }
    }
}
