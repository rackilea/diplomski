public class DisplayText extends Applet implements ItemListener {

    private JTextArea area1 = new JTextArea("", 8, 40);

    private Checkbox Kalin;

    public void init() {

        area1.setFont(new Font("Serif", Font.PLAIN, 14));

        File file = new File("D:\\Denemeler\\deneme1.txt");

        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        StringBuffer fileText = new StringBuffer();
        while(scanner.hasNext()){
            fileText.append(scanner.nextLine());
        }
        area1.setText(fileText.toString());

        add(area1);
        Kalin = new Checkbox("Kalin");
        Kalin.addItemListener(this);
        add(Kalin);
    }

    public void itemStateChanged(ItemEvent e)

    {
        int KalinAyari;
        if (Kalin.getState()) {
            KalinAyari = Font.BOLD;
        } else {
            KalinAyari = Font.PLAIN;
        }

        area1.setFont(new Font("Serif", KalinAyari, 14));
    }

}