public class nameClass extends JFrame{

    //code

    public nameClass(){ // constructor
       Chart chart = new Chart();
       setTitle("Chart");
       add(chart, BorderLayout.CENTER);
       chart.init();
       chart.start();
    }

    public static void main(String[] args) {
          Console.run(new nameClass(),300,400);
    }