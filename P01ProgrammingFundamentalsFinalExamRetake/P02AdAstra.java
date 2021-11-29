package PreviousFinalExams.P01ProgrammingFundamentalsFinalExamRetake;
//You are an astronaut who just embarked on a mission across the solar system. Since you will be in space for a long time, you have packed a lot of food with you. Create a program, which helps you identify how much food you have left and gives you information about its expiration date.
//On the first line of the input, you will be given a text string. You must extract the information about the food and calculate the total calories.
//First, you must extract the food info. It will always follow the same pattern rules:
//It will be surrounded by "|" or "#" (only one of the two) in the following pattern:
//#{item name}#{expiration date}#{calories}#   or
//|{item name}|{expiration date}|{calories}|
//The item name will contain only lowercase and uppercase letters and whitespace
//The expiration date will always follow the pattern: "{day}/{month}/{year}", where the day, month, and year will be exactly two digits long
//The calories will be an integer between 0-10000
//Calculate the total calories of all food items and then determine how many days you can last with the food you have. Keep in mind that you need 2000kcal a day.
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class P02AdAstra {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input=scanner.nextLine();
        String patternString="[#|](\\w+[ \\w+]*)[#|](\\d{2}/\\d{2}/\\d{2})[#|](\\d+)[#|]";
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(input);
        int sum=0;
        while(matcher.find()) {
            sum+=Integer.parseInt(matcher.group(3));
        }
        System.out.printf("You have food to last you for: %d days!\n",sum/2000);
        matcher = pattern.matcher(input);
        while(matcher.find()) {
            System.out.printf("Item: %s, Best before: %s, Nutrition: %s\n",matcher.group(1),matcher.group(2),matcher.group(3));
        }
    }
}
