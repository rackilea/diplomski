public class ListTest extends JPanel{

private static final String[] items = new String[]{"1", "2", "3"};
private JList mylist;
private JComboBox myCombo;
private JTextArea myTA;

public ListTest() {
    setLayout(new BorderLayout());
    myCombo = new JComboBox(items);
    myCombo.addActionListener(new ActionListener(){

        @Override
        public void actionPerformed(ActionEvent e){
            valueSelectedCombo(myCombo.getSelectedIndex());
        }
    });
    JPanel pn = new JPanel();
    pn.setLayout(new BoxLayout(pn, BoxLayout.X_AXIS));
    pn.add(myCombo);
    pn.add(Box.createHorizontalGlue());
    pn.add(new JButton(new AbstractAction("Clear"){

        @Override
        public void actionPerformed(ActionEvent e){
            myTA.setText("");
        }
    }));
    add(pn, BorderLayout.NORTH);
    add(new JScrollPane(getJList()), BorderLayout.WEST);
    add(new JScrollPane(myTA = new JTextArea()), BorderLayout.CENTER);
}

private void valueSelectedList(int index){
    myTA.setText(myTA.getText() + "\n" + items[index]);
}

private void valueSelectedCombo(int index){
    myTA.setText(myTA.getText() + "\n" + items[index]);
    ((CustomSelectionModel)mylist.getSelectionModel()).setSelectionSilent(index);
}

private JList getJList(){
    if (mylist == null){
        mylist = new JList(items);
        mylist.setSelectionModel(new CustomSelectionModel());
        mylist.addListSelectionListener(new ListSelectionListener(){

            @Override
            public void valueChanged(ListSelectionEvent e){
                if (!e.getValueIsAdjusting()){
                    valueSelectedList(mylist.getSelectedIndex());
                }
            }
        });

        mylist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        mylist.setPreferredSize(new Dimension(100, 106));

    }
    return mylist;
}

private static class CustomSelectionModel extends DefaultListSelectionModel{

    private boolean isSilent = false;

    public void setSelectionSilent(int firstIndex){
        isSilent = true;
        setSelectionInterval(firstIndex, firstIndex);
        isSilent = false;
    }
    protected void fireValueChanged(int firstIndex, int lastIndex, boolean isAdjusting){
        if (isSilent){
            return;
        }
        super.fireValueChanged(firstIndex, lastIndex, isAdjusting);
    }
}

public static void main(String[] args){
    JFrame frame = new JFrame("test");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Add content to the window.
    frame.add(new ListTest());

    // Display the window.
    frame.pack();
    frame.setSize(300, 200);
    frame.setVisible(true);
}

}