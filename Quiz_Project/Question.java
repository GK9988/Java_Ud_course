package Quiz_Project;

import java.util.ArrayList;
import java.util.Scanner;

public class Question {

    private String question;

    private ArrayList<String> options;

    private String answer;

    private static Scanner sc = new Scanner(System.in);

    public Question() {

        options = new ArrayList<>();

        System.out.print("Enter the Question: ");
        question = sc.nextLine();
        System.out.println();

        System.out.print("Enter the number of Options: ");
        int lOptions = sc.nextInt();
        sc.nextLine();
        System.out.println();

        for (int i = 0; i < lOptions; i++) {
            System.out.print("\tOption " + (i + 1) + " = ");
            options.add(sc.nextLine());
        }

        System.out.print("Enter the answer of the Question: ");
        answer = sc.nextLine();

    }

    public void displayQuestion() {

        System.out.println(question);

        for (String opt : options) {
            System.out.println("\t->" + opt);
        }

    }

    public boolean checkAnswer(String aInAns) {
        return answer.equals(aInAns);
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

}
