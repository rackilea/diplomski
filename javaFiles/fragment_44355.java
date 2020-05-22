public KMap(int i) 
{
    f = new JFrame();
    f.setTitle("Karnaugh Map for COMP 228");
    f.setLayout(new BorderLayout());
    updateVariables(i);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
    f.setResizable(false);
    f.setLocationRelativeTo(null);
    f.add(this);
    f.setVisible(true);
    run(i);
}