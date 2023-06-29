import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

class Question {
    private String question;
    private List<String> options;
    private int answerIndex;

    public Question(String question, List<String> options, int answerIndex) {
        this.question = question;
        this.options = options;
        this.answerIndex = answerIndex;
    }

    public String getQuestion() {
        return question;
    }

    public List<String> getOptions() {
        return options;
    }

    public boolean isCorrectAnswer(int userAnswer) {
        return userAnswer == answerIndex;
    }
}

public class game {
    private List<Question> questions;
    private Random random;

    public game() {
        questions = new ArrayList<>();
        random = new Random();
    }

    public void addQuestion(String question, List<String> options, int answerIndex) {
        Question q = new Question(question, options, answerIndex);
        questions.add(q);
    }

    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        int score = 0;

        for (Question question : questions) {
            System.out.println(question.getQuestion());
            List<String> options = question.getOptions();
            for (int i = 0; i < options.size(); i++) {
                System.out.println((i + 1) + ". " + options.get(i));
            }

            int userAnswer = scanner.nextInt();
            if (question.isCorrectAnswer(userAnswer)) {
                System.out.println("Correct answer!");
                score++;
            } else {
                System.out.println("Wrong answer!");
            }
            System.out.println();
        }

        System.out.println("Game over! Your score is: " + score + "/" + questions.size());
    }

    public static void main(String[] args) {
        game quizGame = new game();

        quizGame.addQuestion("What is the capital of France?",
                List.of("London", "Paris", "Rome", "Madrid"), 2);

        quizGame.addQuestion("Which planet is known as the Red Planet?",
                List.of("Mars", "Venus", "Jupiter", "Mercury"), 1);

        quizGame.addQuestion("Who painted the Mona Lisa?",
                List.of("Leonardo da Vinci", "Pablo Picasso", "Vincent van Gogh", "Michelangelo"), 1);

        quizGame.addQuestion("What is the capital of Australia?",
                List.of("Sydney", "Melbourne", "Canberra", "Michelangelo"), 3);

        quizGame.addQuestion("In which year did World War II end?",
                List.of("1943", "1946", "1939", "1945"), 4);

        quizGame.addQuestion("What is the largest planet in our solar system?",
                List.of("Mars", "Jupiter", "Saturn", "Neptune"), 2);

        quizGame.addQuestion("Who was the first person to step foot on the moon?",
                List.of("Neil Young", "Buzz Lightyear", "Michael Jackson", "Neil Armstrong"), 4);

        quizGame.startGame();
    }
}
