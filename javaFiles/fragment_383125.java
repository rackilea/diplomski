import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class RandomStuff {

    public static void main(String[] args) {
        new RandomStuff();
    }

    public RandomStuff() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new QuestionPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class QuestionPane extends JPanel {

        private ArrayList<String> SPOquestions = new ArrayList<String>(); // adding the sports questions for the quiz
        private ArrayList<String> MUSquestions = new ArrayList<String>(); // adding the music questions
        private ArrayList<String> GENquestions = new ArrayList<String>(); // adding general knowledge questions

        private JLabel questionLabel;
        private JButton randomButton;

        public QuestionPane() {

            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridwidth = GridBagConstraints.REMAINDER;

            questionLabel = new JLabel();
            randomButton = new JButton("Next question");
            randomButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String text = "?";
                    switch ((int)Math.round(Math.random() * 2)) {
                        case 0:
                            Collections.shuffle(SPOquestions);
                            text = SPOquestions.get(0);
                            break;
                        case 1:
                            Collections.shuffle(MUSquestions);
                            text = MUSquestions.get(0);
                            break;
                        case 2:
                            Collections.shuffle(GENquestions);
                            text = GENquestions.get(0);
                            break;
                    }
                    questionLabel.setText(text);
                }
            });

            add(questionLabel, gbc);
            add(randomButton, gbc);

            SPOquestions.add("Who won the 2005 Formula One World Championship?");
            SPOquestions.add("Which team has the most Formula One Constructors titles?");
            SPOquestions.add("In what year did Roger Federer win his first 'Grand Slam'?");
            SPOquestions.add("How many 'Grand Slams' has Rafael Nadal won?");
            SPOquestions.add("Who has scored the most amount of goals in the Premier League?");
            SPOquestions.add("Who has won the most World Cups in football?");
            SPOquestions.add("How many MotoGP titles does Valentino Rossi hold?");
            SPOquestions.add("Who was the 2013 MotoGP champion?");
            SPOquestions.add("Who won the 2003 Rugby World Cup?");
            SPOquestions.add("In rugby league, how many points are awarded for a try?");
            SPOquestions.add("Who is the youngest ever snooker World Champion?");
            SPOquestions.add("In snooker, what is the highest maximum possible break?");
            SPOquestions.add("How many majors has Tiger Woods won?");
            SPOquestions.add("In golf, what is the tournament between the USA and Europe called?");
            SPOquestions.add("How many World Championships has darts player Phil Taylor won?");
            SPOquestions.add("What is the maximum possible amount of points a player can earn from throwing three darts?");
            SPOquestions.add("How many gold medals did Michael Phelps win at the 2008 Beijing Olympics?");
            SPOquestions.add("Who won the 2012 Olympic 100 metres mens race?");
            SPOquestions.add("Which of these events are not a part of the heptathlon?");
            SPOquestions.add("When was the first modern Olympics held?");

            MUSquestions.add("'Slash' was a member of which US rock band?");
            MUSquestions.add("Brian May was a member of which English rock band?");
            MUSquestions.add("What is the name of the music festival held annually in the town of Boom, Belgium?");
            MUSquestions.add("The rapper Tupac Shakuer '2Pac' died in which year?");
            MUSquestions.add("Which of these bands headlined the 2013 Glastonbury music festival?");
            MUSquestions.add("Which of these people designed the 'Les Paul' series of guitars?");
            MUSquestions.add("Keith Moon was a drummer for which English rock band?");
            MUSquestions.add("Kanye West has a total of how many Grammy awards?");
            MUSquestions.add("Beyonce Knowles was formally a member of which US group?");
            MUSquestions.add("In which US city was rapper 'Biggie Smalls' born?");
            MUSquestions.add("Michael Jackson's first number one single in the UK as a solo artist was what?");
            MUSquestions.add("The best selling album of all time in the UK is what?");
            MUSquestions.add("The best selling album of all time in the US is what?");
            MUSquestions.add("What is the artist known as 'Tiesto's real name?");
            MUSquestions.add("Which of these was not a member of The Beatles?");

            GENquestions.add("Who was the second President of the United States?");
            GENquestions.add("The youngest son of Bob Marley was who?");
            GENquestions.add("In the film '8 Mile', the character portrayed by Eminem is known as what?");
            GENquestions.add("What is the capital city of New Zealand?");
            GENquestions.add("What is the capital city of Australia?");
            GENquestions.add("How many millilitres are there in an English pint?");
            GENquestions.add("What was the biggest selling game for the PS2 worldwide?");
            GENquestions.add("What is the last letter of the Greek alphabet?");
            GENquestions.add("Who created the television series Futurama?");
            GENquestions.add("A word which reads the same backwards as it does forwards is known as a what?");
            GENquestions.add("A 'baker's dozen' consists of how many items?");
            GENquestions.add("World War 1 officially occured on which date?");
            GENquestions.add("'Trouble and strife' is cockney rhyming slang for what?");
            GENquestions.add("Who was the last Prime Minister to hail from the labour party in the UK?");
            GENquestions.add("WalMart is the parent company of which UK based supermarket chain?");

            randomButton.doClick();
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(400, 200);
        }

    }

}