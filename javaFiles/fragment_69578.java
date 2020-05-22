import java.awt.FileDialog;
import java.awt.FontMetrics;
import java.awt.Rectangle;
import java.beans.PropertyVetoException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.AbstractButton;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.text.BadLocationException;
import javax.swing.text.Element;
import javax.swing.text.JTextComponent;

public class OpenDemo extends javax.swing.JFrame implements ChangeListener{



private ArrayList<OInternalFrame> frames = new ArrayList<OInternalFrame>();
private OInternalFrame currentFrame;
int i=0;
public OpenDemo() {
    initComponents();
    viewLineNumbers.setSelected(false);
}
@SuppressWarnings("unchecked")
// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
private void initComponents() {

    tp = new javax.swing.JTabbedPane();
    jMenuBar1 = new javax.swing.JMenuBar();
    jMenu1 = new javax.swing.JMenu();
    open = new javax.swing.JMenuItem();
    cut = new javax.swing.JMenuItem();
    selectAll = new javax.swing.JMenuItem();
    viewLineNumbers = new javax.swing.JCheckBoxMenuItem();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    jMenu1.setText("File");

    open.setText("Open");
    open.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            openActionPerformed(evt);
        }
    });
    jMenu1.add(open);

    cut.setText("Cut");
    cut.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            cutActionPerformed(evt);
        }
    });
    jMenu1.add(cut);

    selectAll.setText("SelectAll");
    selectAll.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            selectAllActionPerformed(evt);
        }
    });
    jMenu1.add(selectAll);

    viewLineNumbers.setSelected(true);
    viewLineNumbers.setText("ViewLineNumbers");
    viewLineNumbers.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            viewLineNumbersActionPerformed(evt);
        }
    });
    jMenu1.add(viewLineNumbers);

    jMenuBar1.add(jMenu1);

    setJMenuBar(jMenuBar1);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(tp, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(tp, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
    );

    pack();
}// </editor-fold>                        

private void openActionPerformed(java.awt.event.ActionEvent evt) {                                     
    FileDialog fd = new FileDialog(OpenDemo.this, "Select File", FileDialog.LOAD);
    fd.show();
    String title;
    String sts;

    if (fd.getFile() != null) {
       sts = fd.getDirectory() + fd.getFile();
       title=fd.getFile();
       System.out.println(sts);
       title=fd.getFile();
       BufferedReader br = null;
       StringBuffer str = new StringBuffer("");
       try {
           br = new BufferedReader(new FileReader(sts));
           String line;
           try {
                while ((line = br.readLine()) != null) {
                str.append(line + "\n");
                }
           } catch (IOException ex) {
                Logger.getLogger(OpenDemo.class.getName()).log(Level.SEVERE, null, ex);
             }
       } catch (FileNotFoundException ex) {
            Logger.getLogger(OpenDemo.class.getName()).log(Level.SEVERE, null, ex);
         }
       String t = str.toString(); 
       OInternalFrame internalFrame = new OInternalFrame("",true,true);  


       i++;
       internalFrame.setName("Doc "+i);
       internalFrame.setTitle(title);
       try {
            internalFrame.setSelected(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(OpenDemo.class.getName()).log(Level.SEVERE, null, ex);
       }


       internalFrame.addInternalFrameListener(new InternalFrameAdapter() {
           @Override
           public void internalFrameClosing(InternalFrameEvent e) {
               i--;

               frames.remove(currentFrame);
               tp.remove(currentFrame);
               for(OInternalFrame frame : frames)
              {
                  int index=frames.indexOf(frame);

                  tp.setTitleAt(index, "Doc "+(index+1));

              }

           }
       });
       tp.add(internalFrame);
       tp.setSelectedIndex(i-1);  



       tp.addChangeListener(this);
       frames.add(internalFrame);
       currentFrame=internalFrame;
       currentFrame.setText(t);
       currentFrame.setVisible(true);
       currentFrame.setLineViewer(viewLineNumbers.isSelected());

}     
}                                    

private void cutActionPerformed(java.awt.event.ActionEvent evt) {                                    
    currentFrame.cut();
}                                   

private void selectAllActionPerformed(java.awt.event.ActionEvent evt) {                                          
    currentFrame.selectAll();
}                                         

private void viewLineNumbersActionPerformed(java.awt.event.ActionEvent evt) {                                                
    AbstractButton button = (AbstractButton) evt.getSource();

                      currentFrame.setLineViewer(viewLineNumbers.isSelected());

}                                               
public static void main(String args[]) {
    try {
        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
                javax.swing.UIManager.setLookAndFeel(info.getClassName());
                break;
            }
        }
    } catch (ClassNotFoundException ex) {
        java.util.logging.Logger.getLogger(OpenDemo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
        java.util.logging.Logger.getLogger(OpenDemo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
        java.util.logging.Logger.getLogger(OpenDemo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
        java.util.logging.Logger.getLogger(OpenDemo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>
    java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            new OpenDemo().setVisible(true);
        }
    });
}

// Variables declaration - do not modify                     
private javax.swing.JMenuItem cut;
private javax.swing.JMenu jMenu1;
private javax.swing.JMenuBar jMenuBar1;
private javax.swing.JMenuItem open;
private javax.swing.JMenuItem selectAll;
private javax.swing.JTabbedPane tp;
private javax.swing.JCheckBoxMenuItem viewLineNumbers;
// End of variables declaration                   

@Override
public void stateChanged(ChangeEvent ce) {
    JTabbedPane sourceTabbedPane = (JTabbedPane) ce.getSource();
    int index = sourceTabbedPane.getSelectedIndex();
    try
    {
      currentFrame =frames.get(index);
      currentFrame.setLineViewer(viewLineNumbers.isSelected());
    }
    catch(IndexOutOfBoundsException e1){
    }
}
public int getLineAtCaret(JTextComponent component)
{
    int caretPosition = component.getCaretPosition();
    Element root = component.getDocument().getDefaultRootElement();
    return root.getElementIndex( caretPosition ) + 1;
}
public int getColumnAtCaret(JTextComponent component)
{
    FontMetrics fm = component.getFontMetrics( component.getFont() );
    int characterWidth = fm.stringWidth( "0" );
    int column = 0;
    try
    {
        Rectangle r = component.modelToView( component.getCaretPosition() );
        int width = r.x - component.getInsets().left;
        column = width / characterWidth;
    }
    catch(BadLocationException ble) {}
    return column + 1;
}
}