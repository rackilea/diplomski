import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class TestQuestions extends JPanel {
    private static final Question TEST_QUESTION = new Question("Select the Correct Answer", "This answer is correct", 
            "Incorrect Answer 1", "Incorrect Answer 2", "Incorrect Answer 3");
    private QuestionPanel questionPanel = new QuestionPanel();

    public TestQuestions() {
        questionPanel.setQuestion(TEST_QUESTION);
        JButton testAnswerBtn = new JButton(new AbstractAction("Test Answer") {

            @Override
            public void actionPerformed(ActionEvent e) {
                boolean isCorrect = questionPanel.isCorrectAnswerSelected();
                String message = "";
                if (isCorrect) {
                    message = "Correct answer selected!";
                } else {
                    message = "Incorrect answer selected!";                    
                }
                JOptionPane.showMessageDialog(TestQuestions.this, message);
                questionPanel.displayCorrectWrongAnswers();
            }
        });
        JButton clearAllBtn = new JButton(new AbstractAction("Clear All") {

            @Override
            public void actionPerformed(ActionEvent e) {
                questionPanel.clearAll();
                questionPanel.clearSelection();
            }
        });

        JPanel btnPanel = new JPanel(new GridLayout(1, 0, 5, 5));
        btnPanel.add(testAnswerBtn);
        btnPanel.add(clearAllBtn);

        setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        setLayout(new BorderLayout(5, 5));
        add(questionPanel, BorderLayout.CENTER);
        add(btnPanel, BorderLayout.PAGE_END);
    }

    private static void createAndShowGui() {
        JFrame frame = new JFrame("TestQuestions");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new TestQuestions());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGui();
            }
        });
    }
}

@SuppressWarnings("serial")
class QuestionPanel extends JPanel {
    private static final Color CORRECT_ANSWER_SELECTED_COLOR = new Color(151, 255, 151);
    private static final Color CORRECT_ANSWER_NOT_SELECTED_COLOR = new Color(151,151, 255);
    private static final Color INCORRECT_ANSWER_SELECTED_COLOR = new Color(255, 151, 151);
    private Question question;
    private JLabel questionTextLabel = new JLabel();
    private List<JRadioButton> answerButtonList = new ArrayList<>();
    private JPanel answerPanel = new JPanel(new GridLayout(0, 1));
    private ButtonGroup buttonGroup = new ButtonGroup();

    public QuestionPanel() {
        setLayout(new BorderLayout());
        add(questionTextLabel, BorderLayout.PAGE_START);
        add(answerPanel, BorderLayout.CENTER);
    }

    public void setQuestion(Question question) {
        this.question = question;
        questionTextLabel.setText(question.getQuestionText());

        answerPanel.removeAll();
        answerButtonList.clear();
        buttonGroup = new ButtonGroup();

        for (String answer : question.getShuffledAnswers()) {
            JRadioButton rBtn = new JRadioButton(answer);
            rBtn.setActionCommand(answer);
            answerButtonList.add(rBtn);
            buttonGroup.add(rBtn);
            answerPanel.add(rBtn);
        }
    }

    public boolean isCorrectAnswerSelected() {
        ButtonModel model = buttonGroup.getSelection();
        if (model == null) {
            return false; // nothing selected
        } else {
            return question.checkAnswer(model.getActionCommand());
        }
    }

    public void clearAll() {
        for (JRadioButton jRadioButton : answerButtonList) {
            jRadioButton.setOpaque(false);
            jRadioButton.setBackground(null);
        }
    }

    public void clearSelection() {
        buttonGroup.clearSelection();
    }

    public void displayCorrectWrongAnswers() {
        clearAll();
        for (JRadioButton jRadioButton : answerButtonList) {
            if (jRadioButton.isSelected()) {
                jRadioButton.setOpaque(true);
                if (question.checkAnswer(jRadioButton.getActionCommand())) {
                    jRadioButton.setBackground(CORRECT_ANSWER_SELECTED_COLOR);
                } else {
                    jRadioButton.setBackground(CORRECT_ANSWER_NOT_SELECTED_COLOR);
                }
            } else if (question.checkAnswer(jRadioButton.getActionCommand())) {
                jRadioButton.setOpaque(true);
                jRadioButton.setBackground(INCORRECT_ANSWER_SELECTED_COLOR);
            }
        }
    }

}

class Question {
    private String questionText;
    private String correctAnswer;
    private List<String> incorrectAnswerList = new ArrayList<>();
    public Question(String questionText, String correctAnswer, String... incorrectAnswers) {
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
        for (String incorrectAnswer : incorrectAnswers) {
            incorrectAnswerList.add(incorrectAnswer);
        }
    }

    public String getQuestionText() {
        return questionText;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public List<String> getShuffledAnswers() {
        List<String> answers = new ArrayList<>(incorrectAnswerList);
        answers.add(correctAnswer);
        Collections.shuffle(answers);
        return answers;
    }

    public boolean checkAnswer(String test) {
        return correctAnswer.equalsIgnoreCase(test);
    }

}