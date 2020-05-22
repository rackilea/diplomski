public class LiqPlantSim extends JFrame{

    public Silo silo,silo2,silo3,silo4;

    public LiqPlantSim(){
        super("Liq Plant Simulator");
        this.setFont(new Font("Helvetica", Font.PLAIN, 14));
        this.setBackground(Color.red);

        setLayout(new GridLayout(2, 2));

        silo = new Silo();
        this.add(silo);
        silo2 = new Silo();
        this.add(silo2);
        silo3 = new Silo();
        this.add(silo3);
        silo4 = new Silo();
        this.add(silo4);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);  
        this.pack();
        this.setLocation(100,100);
        this.setVisible(true);
        this.toFront();            
    }


}