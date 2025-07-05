import java.util.*;

public class Quiz {
    private List<Question> questions;
    private int score;

    public Quiz() {
        questions = new ArrayList<>();
        score = 0;
        loadQuestions();
    }

    private void loadQuestions() {
        questions.add(new Question(
            "What is the capital of France?",
            new String[]{"London", "Paris", "Berlin", "Rome"},
            2
        ));
        questions.add(new Question(
            "Which planet is known as the Red Planet?",
            new String[]{"Earth", "Venus", "Mars", "Jupiter"},
            3
        ));
        questions.add(new Question(
            "Who wrote 'Romeo and Juliet'?",
            new String[]{"Charles Dickens", "William Shakespeare", "J.K. Rowling", "Jane Austen"},
            2
        ));
        questions.add(new Question(
            "What is the square root of 64?",
            new String[]{"6", "7", "8", "9"},
            3
        ));
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        for (Question q : questions) {
            q.displayQuestion();
            System.out.print("Enter your answer (1-4): ");
            int answer;
            try {
                answer = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid input! Skipping question.");
                continue;
            }
            if (q.checkAnswer(answer)) {
                System.out.println("✅ Correct!");
                score++;
            } else {
                System.out.println("❌ Incorrect!");
            }
        }
        showResult();
        scanner.close();
    }

    private void showResult() {
        System.out.println("\n🧾 Quiz Completed!");
        System.out.println("You scored " + score + " out of " + questions.size());
    }
}