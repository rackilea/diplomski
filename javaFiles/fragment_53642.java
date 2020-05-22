import javax.sound.midi.*;
import javax.swing.*;
import java.awt.event.*;
import java.net.URL;

class PlayMidi {

    public static void main(String[] args) throws Exception {
        URL url = new URL("http://pscode.org/media/EverLove.mid");
        Sequence sequence = MidiSystem.getSequence(url);
        final Sequencer sequencer = MidiSystem.getSequencer();
        sequencer.open();
        sequencer.setSequence(sequence);
        Runnable r = new Runnable() {
            public void run() {
                final JProgressBar progress = new JProgressBar(0,(int)sequencer.getMicrosecondLength()); 
                ActionListener updateListener = new ActionListener(){
                    public void actionPerformed(ActionEvent arg0) {
                        progress.setValue((int)sequencer.getMicrosecondPosition());
                    }
                };
                Timer timer = new Timer(40,updateListener); 
                sequencer.start();
                timer.start();
                JOptionPane.showMessageDialog(null, progress);
                sequencer.close();
                timer.stop();
            }
        };
        SwingUtilities.invokeLater(r);
    }
}