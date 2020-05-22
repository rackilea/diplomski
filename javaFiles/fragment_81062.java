static JFrame frame=new JFrame(); 
static JPanel panel=new JPanel();
private static void display(JFrame frame) throws IOException 
    {
        JFileChooser chooser = new JFileChooser();
        int returnVal = chooser.showOpenDialog(null); 
        File file = null;
        if(returnVal == JFileChooser.APPROVE_OPTION)     
        file = chooser.getSelectedFile();    
        JTextArea text = new JTextArea();
        BufferedReader in = new BufferedReader(new FileReader(file));
        String line = in.readLine();
        while(line != null)
            {
                text.append(line + "\n");
                line = in.readLine();
            }
        panel.add(text);
        frame.add(panel);
    }
public static void main(String args[]) throws IOException
{
    frame. setTitle("Simple example");
    frame.setSize(500, 500);
    display(frame);
    frame.setVisible(true);
}