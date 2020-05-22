public static void main(String[] args) {
    new QuizMain();
}

public QuizMain() {
    EventQueue.invokeLater(new Runnable() {
        @Override
        public void run() {
            try {
                UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                ex.printStackTrace();
            }

            List<Question> quiz = new ArrayList<>(5);
            // Couple of conceptual mistakes here.... 
            quiz.add(new ChoiceQuestion("Where is Japan Located?", "Asia", "North America", "Africa", "Europe", "Asia"));
            // There was a mistake, correct answer is 2
            // quiz.add(new ChoiceQuestion("1 + 1:", "2", "4", "3", "1"));
            quiz.add(new ChoiceQuestion("1 + 1:", "2", "4", "3", "2", "1"));

            JFrame frame = new JFrame("QUIZ TIME!");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(new QuizPane(quiz));
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        }
    });
}

public class QuizPane extends JPanel {

    private List<Question> quiz;

    private long countdown = 10;
    private Timer timer;
    private JButton next;
    private JButton intro;


    private CardLayout cardLayout;
    private int currentQuestion;

    private JPanel QuestionsPanel;

    private Long startTime;

    public QuizPane(List<Question> quiz) {
        this.quiz = quiz;
        cardLayout = new CardLayout();
        QuestionsPanel = new JPanel(cardLayout);
        QuestionsPanel.setBorder(new EmptyBorder(40,45,40,45));

        JButton start = new JButton("Start");
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentQuestion = -1;
                nextQuestion();
                timer.start();
            }
        });

        JButton intro = new JButton("Instructions");
        intro.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            instructionBox();
          }
        });


        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.add(start);
        mainPanel.add(intro);
        QuestionsPanel.add(mainPanel, "start");


        for (int index = 0; index < quiz.size(); index++) {
            Question question = quiz.get(index);
            QuestionPane pane = new QuestionPane(question);
            question.setButtonGroup(pane.getButtonGroup());
            QuestionsPanel.add(pane, Integer.toString(index));
        }
        QuestionsPanel.add(new JLabel("You have finished the Quiz"), "last");
        currentQuestion = 0;
        cardLayout.show(QuestionsPanel, "Start");

        setLayout(new BorderLayout());
        add(QuestionsPanel);

        JPanel buttonPane = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        next = new JButton("Next");
        buttonPane.add(next);
        next.setEnabled(false);

        add(buttonPane, BorderLayout.SOUTH);

        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nextQuestion();
            }
        });

        timer = new Timer(250, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (startTime == null) {
                    startTime = System.currentTimeMillis();
                }
                long duration = (System.currentTimeMillis() - startTime) / 1000;
                if (duration >= countdown) {
                    nextQuestion();
                } else {
                    long timeLeft = countdown - duration;
                    next.setText("Next (" + timeLeft + ")");
                    next.repaint();
                }
            }
        });
    }

    protected void nextQuestion() {
        // store the selected answer for each question
        if (currentQuestion >= 0 && currentQuestion < quiz.size() ) {
            Question currentQObject = quiz.get(currentQuestion);
            if (currentQObject != null) {
                currentQObject.setUserResponse(getSelected(currentQObject.getButtonGroup()));
            }
        }
        timer.stop();
        currentQuestion++;
        if (currentQuestion >= quiz.size()) {
            cardLayout.show(QuestionsPanel, "last");
            next.setEnabled(false);
            //Show however many correct after last question. 
            //iterate on the collection to count the selected radio buttons
            //What im confused about is really how do i tell the program which (options) are right or wrong. 
            //and if i can do that how do i only count the correct ones. 
            //or for example do i have to take the total questions and subtract by the ones they didnt choose? 
            //a code example on how to do this would be great.

            // Just iterate over quiz list to check if answers are correct:
            int totalCorrect = 0;
            for (Question q : quiz) {
                if (q.isCorrect()) { 
                    totalCorrect++;
                }
            }

            // Show Corrects any way....
            System.out.println("Total correct responses: " + totalCorrect);

        } else {
            cardLayout.show(QuestionsPanel, Integer.toString(currentQuestion));
            startTime = null;
            next.setText("Next");
            next.setEnabled(true);
            timer.start();
        }
    }

    private String getSelected(ButtonGroup buttonGroup) {
        JRadioButton selectedRadio = null;
        Enumeration e = buttonGroup.getElements();
        while (e.hasMoreElements()) {
            JRadioButton rad = (JRadioButton) e.nextElement();
            if (rad.isSelected()) {
                selectedRadio = rad;
                break;
            }
        }
        return selectedRadio.getText();
    }

    protected void instructionBox() {
        JOptionPane.showMessageDialog(null,"<html><b><div width='111px' height = '82px' align='justified'> 1.You have limited time to answer each question and your score will be shown at the end of the test. Good Luck!</div></body></html>",
        "Instructions",
        JOptionPane.INFORMATION_MESSAGE);
     }
 }

public interface Question {

    public String getPrompt();

    public void setButtonGroup(ButtonGroup buttonGroup);

    public ButtonGroup getButtonGroup();

    public String getCorrectAnswer();

    public String[] getOptions();

    public String getUserResponse();

    public void setUserResponse(String response);

    public boolean isCorrect();
}

public class ChoiceQuestion implements Question {

    private final String prompt;
    private final String correctAnswer;
    private final String[] options;
    private ButtonGroup buttonGroup;

    private String userResponse;

    public ChoiceQuestion(String prompt, String correctAnswer, String... options) {
        this.prompt = prompt;
        this.correctAnswer = correctAnswer;
        this.options = options;
    }

    @Override
    public void setButtonGroup(ButtonGroup buttonGroup) {
        this.buttonGroup = buttonGroup;
    }

    @Override
    public ButtonGroup getButtonGroup() {
        return this.buttonGroup;
    }

    @Override
    public String getPrompt() {
        return prompt;
    }

    @Override
    public String getCorrectAnswer() {
        return correctAnswer;
    }

    @Override
    public String[] getOptions() {
        return options;
    }

    @Override
    public String getUserResponse() {
        return userResponse;
    }

    @Override
    public void setUserResponse(String response) {
        userResponse = response;
    }

    @Override
    public boolean isCorrect() {
        return getCorrectAnswer().equals(getUserResponse());
    }
}

public class QuestionPane extends JPanel {

    private Question question;

    private ButtonGroup buttonGroup = null;

    public QuestionPane(Question question) {
        this.question = question;

        setLayout(new BorderLayout());

        JLabel prompt = new JLabel("<html><b>" + question.getPrompt() + "</b></html>");
        prompt.setHorizontalAlignment(JLabel.LEFT);

        add(prompt, BorderLayout.NORTH);

        JPanel guesses = new JPanel(new GridBagLayout());
        guesses.setBorder(new EmptyBorder(10,10,10,10));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.weightx = 1;
        gbc.anchor = GridBagConstraints.WEST;

        List<String> options = new ArrayList<>(Arrays.asList(question.getOptions()));
        //options.add(question.getCorrectAnswer());
        Collections.sort(options);

        ButtonGroup bg = new ButtonGroup();
        for (String option : options) {
            JRadioButton btn = new JRadioButton(option);
            btn.setName(option);
            bg.add(btn);

            guesses.add(btn, gbc);
        }
        this.buttonGroup = bg;

        add(guesses);
    }

    public ButtonGroup getButtonGroup() {
        return buttonGroup;
    }

    public Question getQuestion() {
        return question;
    }

    public class ActionHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            getQuestion().setUserResponse(e.getActionCommand());
        }

    }

}