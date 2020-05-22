import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Rectangle;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Element;
import javax.swing.text.JTextComponent;


public class OInternalFrame extends JInternalFrame
{
    private JTextArea textPane;
    private JScrollPane scrollPane;
    private JTextPane linePane;
    private JTextField status;
    private DocumentListener listen;
    public OInternalFrame(String title,boolean resizable,boolean closable)
    {
        super(title,resizable,closable);
        initComponents();
        initListeners();
    }
    private void initComponents()
    {

        textPane = new JTextArea();
        linePane = new JTextPane();
        status = new JTextField();
        scrollPane = new JScrollPane();
        textPane.setFont(new java.awt.Font("Miriam Fixed", 0, 13));
        status.setBackground(Color.LIGHT_GRAY);

        linePane.setEditable(false);
        linePane.setSize(50,50);
        linePane.setFont(new java.awt.Font("Miriam Fixed", 0, 13));
        status.setEditable(false);
//        add(textPane);

        add(scrollPane);

        add(status,BorderLayout.SOUTH);
        scrollPane.getViewport().add(textPane);
        scrollPane.setRowHeaderView(linePane); 
        setVisible(true);
        linePane.setVisible(false);
        updateStatus(1,1);
        scrollPane.setVisible(true);

    }
    private void initListeners()
    {
        textPane.addCaretListener(new CaretListener() {
            @Override
            public void caretUpdate(CaretEvent e) {

                int linenum = 1;
                int columnnum = 1;
                try {
                    int caretpos = textPane.getCaretPosition();
                    linenum=getLineAtCaret()-1;
                    columnnum=getColumnAtCaret();
                    linenum += 1;
                }
                catch(Exception ex) { }
                updateStatus(linenum, columnnum);
            }
        });
        listen = new DocumentListener(){
            @Override
            public void changedUpdate(DocumentEvent de) {
            linePane.setText(getText());
          }
         @Override
         public void insertUpdate(DocumentEvent de) {
          linePane.setText(getText());
         }
         @Override
         public void removeUpdate(DocumentEvent de) {
          linePane.setText(getText());
         }
        };


         }

    public int getLineAtCaret()
    {   
        int line = 0;
        int caretPosition = textPane.getCaretPosition();


        try {
            line = textPane.getLineOfOffset(caretPosition);

        } catch (BadLocationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return line+1;
    }

    public int getColumnAtCaret()
    {
        FontMetrics fm = textPane.getFontMetrics( textPane.getFont() );
        int characterWidth = fm.stringWidth( "0" );
        int column = 0;
        try
        {
            Rectangle r = textPane.modelToView( textPane.getCaretPosition() );
            int width = r.x - textPane.getInsets().left;
            column = width / characterWidth;
        }
        catch(BadLocationException ble) {}
        return column + 1;
    }

    private void updateStatus(int linenumber, int columnnumber) 
    {
        status.setText("Line: " + linenumber + " Column: " + columnnumber);
    }    


    public void setText(String t)
    {
        System.out.println(t);

        textPane.setText(t);

        textPane.setCaretPosition(0);
        textPane.setVisible(true);
        textPane.repaint();
    }
    public void setLineViewer(boolean enabled)
    {
        if(enabled)
        {
        linePane.setText(getText());
        linePane.setCaretPosition(0);
        linePane.revalidate();
        linePane.repaint();

        textPane.getDocument().addDocumentListener(listen);
        }
        else
        {
            linePane.setText("");
            textPane.getDocument().removeDocumentListener(listen);
        }


        linePane.setVisible(enabled);
    }
    public void cut()
    {
        textPane.cut();
    }
    public void selectAll()
    {
        textPane.selectAll();
    }
    public String getText(){
        int caretPosition = textPane.getLineCount();

        String text = "1" + System.getProperty("line.separator");
        for(int i = 2; i <=  caretPosition-1; i++){
            text += i + System.getProperty("line.separator");
        }
        return text;
     }
}