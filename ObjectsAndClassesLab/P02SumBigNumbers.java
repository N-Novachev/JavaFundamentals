package ObjectsAndClasses.ObjectsAndClassesLab;

// You will receive two numbers (0 to 1050), print their sum.

import java.util.Scanner;
import java.math.BigInteger;
public class P02SumBigNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BigInteger num1=new BigInteger(scanner.nextLine());
        BigInteger num2=new BigInteger(scanner.nextLine());
        BigInteger answer=num1.add(num2);
        System.out.println(answer);
    }
}
