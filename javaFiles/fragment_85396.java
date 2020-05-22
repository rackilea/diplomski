public class Prototype extends JFrame{

    private static int count;

    private JLabel l;

    public Prototype() {
        super();

        JButton b = new JButton("click");

        l = new JLabel("0");

        JPanel p = new JPanel();

        b.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                count++;

                l.setText(Integer.toString(count));

            }

        });

        p.add(l);

        p.add(b);

        this.getContentPane().add(p, BorderLayout.CENTER);
        this.pack();
        this.setVisible(true);
    }

    public static void main(String...args){
        Prototype p=new Prototype();
    }

}