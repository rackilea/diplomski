import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class TestKaraoke {

    private JFrame frame;
    private Timer timer;
    private StyledDocument doc;
    private JTextPane textpane;

    private int index = 0;

    public void startColoring() {
        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                highlightNextWord();
            }
        };
        timer = new Timer(50, actionListener);
        timer.setInitialDelay(0);
        timer.start();
    }

    protected void highlightNextWord() {
        boolean reachedEnd = false;
        SimpleAttributeSet sas = new SimpleAttributeSet();
        StyleConstants.setForeground(sas, Color.RED);
        int end = textpane.getText().indexOf(' ', index + 1);
        if (end == -1) {
            end = textpane.getDocument().getLength();
            reachedEnd = true;
        }
        ((StyledDocument) textpane.getDocument()).setCharacterAttributes(index, end - index, sas, true);
        try {
            Rectangle modelToView = textpane.modelToView(end);
            textpane.scrollRectToVisible(modelToView);
        } catch (BadLocationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        index = end;
        if (reachedEnd) {
            timer.stop();
        }
    }

    public void initUI() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        doc = new DefaultStyledDocument();
        textpane = new JTextPane(doc);
        textpane.setText(TEXT);
        frame.add(new JScrollPane(textpane));
        frame.setSize(300, 300);
        frame.setVisible(true);
    }

    public static void main(String args[]) throws InterruptedException, InvocationTargetException {
        SwingUtilities.invokeAndWait(new Runnable() {
            @Override
            public void run() {
                TestKaraoke karaoke = new TestKaraoke();
                karaoke.initUI();
                karaoke.startColoring();
            }
        });
    }

    private static final String TEXT = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras at vulputate nisi. Phasellus varius massa turpis, eget commodo quam. Vivamus vel varius neque. Cras vestibulum aliquet arcu, sed fringilla elit pretium vel. Nunc nibh tellus, dignissim vitae scelerisque vulputate, hendrerit eu arcu. Aenean tincidunt, sem ut sollicitudin blandit, lorem nulla placerat turpis, condimentum mollis felis risus sed leo. Proin a nisi tristique nisi convallis faucibus vitae ut nulla. Sed aliquam, dolor id lobortis pellentesque, nisl mi sagittis mi, sed bibendum arcu arcu vitae odio. Nunc dapibus, tellus non convallis convallis, augue ipsum lobortis massa, sit amet porta lectus augue non lorem. Nam hendrerit vestibulum risus quis accumsan. Mauris ac eros ipsum. Curabitur et odio nulla, sed egestas lorem. Integer sed pretium diam. Vivamus ullamcorper tortor eu ante iaculis non ullamcorper ante consectetur. Sed sit amet lacus enim, et faucibus dui. Vestibulum tempor luctus lorem non lacinia.\r\n"
            + "\r\n"
            + "Vivamus euismod interdum iaculis. Cras diam odio, venenatis sed hendrerit eget, hendrerit ac dolor. Integer vulputate, lorem et auctor hendrerit, elit elit mattis felis, ut mollis velit est quis quam. Vestibulum vel eros mauris, at ultrices tellus. Proin ac lectus lectus. Morbi vehicula ullamcorper tortor a adipiscing. Ut turpis elit, consectetur id vehicula sed, tempor quis augue. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Maecenas est enim, pulvinar id aliquam convallis, vehicula non enim.\r\n"
            + "\r\n"
            + "Praesent porttitor eros eros, sed mattis ante. Maecenas lobortis condimentum ante, ac condimentum nibh malesuada nec. Mauris luctus facilisis magna non elementum. Vestibulum nibh ante, fringilla ut hendrerit ac, dignissim tempus felis. Duis odio orci, ultrices quis blandit vel, feugiat eu orci. Donec sit amet cursus nulla. Vivamus pharetra posuere tellus, venenatis sollicitudin velit dignissim et. Fusce commodo enim non dui malesuada at malesuada neque semper. Sed dui lacus, auctor vel viverra in, molestie sed leo.\r\n"
            + "\r\n"
            + "Suspendisse potenti. In ipsum mi, scelerisque pellentesque rutrum quis, pretium interdum velit. Suspendisse euismod, velit vel tristique semper, odio mauris gravida eros, mollis dictum massa justo ullamcorper tortor. Donec ut dolor felis. Duis dapibus condimentum orci, vel tempor orci egestas ac. Proin eleifend facilisis ipsum, sit amet volutpat neque suscipit ut. Phasellus lobortis tempor nulla, a tristique neque vulputate in. Integer arcu elit, pharetra in ullamcorper in, semper eu libero. Nunc ac felis iaculis eros placerat viverra. Praesent in nibh nibh, vel elementum nisi. Morbi posuere elementum est, at vulputate est interdum in.\r\n"
            + "\r\n"
            + "Proin nisi libero, rhoncus eget bibendum et, aliquet eget nisi. Sed bibendum, ante eu adipiscing mattis, turpis lacus mollis odio, id iaculis mauris felis eu justo. In hac habitasse platea dictumst. In hac habitasse platea dictumst. Duis lobortis placerat odio, sed commodo sapien vulputate volutpat. Vestibulum pretium faucibus justo, ac rutrum risus vulputate ut. Nulla interdum malesuada tortor in cursus. Mauris libero neque, sagittis ornare tristique a, pretium sed eros. Nulla consectetur feugiat nunc eget tincidunt. Integer luctus, mi non euismod congue, nibh risus posuere magna, eget mattis orci elit ut sapien. Nam eu imperdiet sapien. Etiam non commodo turpis. ";
}