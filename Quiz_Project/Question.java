package Quiz_Project;

import java.util.ArrayList;
import java.util.Scanner;

public class Question {

    private String question;

    private ArrayList<String> options;

    private String answer;

    private static Scanner sc = new Scanner(System.in);

    public Question() {
        System.out.println("Enter the Question: ");
        question = sc.nextLine();
        System.out.println();

        System.out.println("Enter the number of Options: ");
        int lOptions = sc.nextInt();
        System.out.println();

        for (int i = 0; i < lOptions; i++) {
            System.out.println("\tOption " + i + 1 + " = ");
            options.add(sc.nextLine());
            System.out.println();
        }

        System.out.println("Enter the answer of the Question: ");
        answer = sc.nextLine();

    }

    public void displayQuestion() {

    }

    public boolean checkAnswer() {
        return false;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

}
