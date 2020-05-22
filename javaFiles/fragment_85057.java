public class FileA {
    public FileA() { 
        JFrame jf = new JFrame();
        jf.setLayout(new BorderLayout());

        FileB b = new FileB();

        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setBounds(100,100,800,600);
        jf.setVisible(true);

        add(b, BorderLayout.CENTER);
    }
    public static void main(String[] args) {
        new FileA();
    }
}