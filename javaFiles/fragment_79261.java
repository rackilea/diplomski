import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class AbstractButtonActionListener 
                                implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        if(commonActionPerformed(e)){
            customActionPerfroemd(e);
        }
    }

    public abstract void customActionPerfromed(ActionEvent e);


    /**
     * 
     * @param e
     * @return true if the custom aciton should be performed
     */
    public boolean commonActionPerformed(ActionEvent e) {
        //method implementation
    }

}