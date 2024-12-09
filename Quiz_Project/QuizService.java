package Quiz_Project;

import java.util.ArrayList;
import java.util.Scanner;

public class QuizService {

    private String studentName;

    private int studentScore;

    private Boolean quizStatus;

    private Boolean isAdmin;

    private ArrayList<Question> questions;

    private static Scanner sc = new Scanner(System.in);

    public QuizService() {
        quizStatus = true;
        questions = new ArrayList<>();
    }

    private void clearConsole() {
        for (int i = 0; i < 100; i++) {
            System.out.println();
        }
    }

    public void startQuizService() {

        while (quizStatus) {
            System.out.println("*********************************** QUIZ ***********************************");
            System.out.println("Press 1 for Admin, Press 2 for Student");

            int user = sc.nextInt();
            isAdmin = user == 1 ? true : false;

            if (isAdmin) {
                clearConsole();
                adminStuff();
            } else {
                clearConsole();
                studentStuff();
            }

            System.out.println("Press 1 to Continue, Press 2 to Exit");
            int choice = sc.nextInt();
            quizStatus = choice == 2 ? false : true;
        }

    }

    private void studentStuff() {

        if (questions.size() == 0) {
            System.out.println("No Questions Present.");
            return;
        }

        System.out.println("Enter your Name: ");
        studentName = sc.nextLine();
        studentScore = 0;

        int qNo = 0;

        for (Question q : questions) {
            clearConsole();
            System.out.println("******** Question - " + ++qNo + " ********");
            System.out.println("User - " + studentName);
            System.out.println("Current Score = " + studentScore);
            System.out.println("\n");
            q.displayQuestion();

            System.out.println("\nEnter Your Answer: ");
            String lAns = sc.nextLine();

            boolean lAnsCheck = q.checkAnswer(lAns);

            if (lAnsCheck) {
                System.out.println("Correct Answer!");
                studentScore++;
            } else {
                System.out.println("Wrong Answer!!!");
                System.out.println("Correct Answer is: " + q.getAnswer());
            }
        }

        clearConsole();
        System.out.println("************** Quiz Completed **************");
        System.out.println("\n");
        System.out.println("Student Name: " + studentName);
        System.out.println("Final Score = " + studentScore);
        System.out.println("\tCorrect Answers = " + studentScore);
        System.out.println("\tWrong Answers = " + (questions.size() - studentScore));
    }

    private void adminStuff() {
        System.out.println("Press 1 to Add Questions, Press 2 to see the list of Questions");

        int choice = sc.nextInt();

        if (choice == 1) {
            clearConsole();
            questions.add(new Question());
        } else {
            clearConsole();
            listQuestions();
        }
    }

    private void listQuestions() {

        int i = 1;

        System.out.println("Total Number of Questions = " + questions.size());

        for (Question q : questions) {
            System.out.println("\t" + i++ + " " + q.getQuestion());
        }

    }

}
