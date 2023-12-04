import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class QuizApplication {
    private static final int QUIZ_DURATION_SECONDS = 60;
    private static int score = 0;

    public static void main(String[] args) {
        startQuiz();
    }

    private static void startQuiz() {
        System.out.println("Welcome to the Quiz!");
        System.out.println("You have " + QUIZ_DURATION_SECONDS + " seconds to answer the questions.");

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                endQuiz();
            }
        }, QUIZ_DURATION_SECONDS * 1000);

        askQuestions();

        timer.cancel(); // Stop the timer when all questions are answered
        endQuiz();
    }

    private static void askQuestions() {
        // Add your quiz questions here
        // You can use an array or a list to store questions and answers

        String[] questions = {
                "What is the capital of France?",
                "Who wrote 'Romeo and Juliet'?",
                // Add more questions...
        };

        String[] answers = {
                "Paris",
                "William Shakespeare",
                // Add more answers...
        };

        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < questions.length; i++) {
            System.out.println("Question " + (i + 1) + ": " + questions[i]);
            String userAnswer = scanner.nextLine();

            if (userAnswer.equalsIgnoreCase(answers[i])) {
                System.out.println("Correct!\n");
                score++;
            } else {
                System.out.println("Incorrect. The correct answer is: " + answers[i] + "\n");
            }
        }
    }

    private static void endQuiz() {
        System.out.println("Quiz ended!");
        System.out.println("Your score: " + score);
        System.exit(0);
    }
}
