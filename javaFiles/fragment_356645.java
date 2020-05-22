public class coffeeprogram {
    public static void main(String[] args) {
        // GUI stuff
        GUI window = new GUI();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(200, 200);
        window.setVisible(true);
        window.setTitle("Coffee Program");


        CoffeeReturn returnPrice = new CoffeeReturn();

        String returnDesc = returnPrice.CoffeeDesc(1101101);
        window.outputDesc.setText(returnDesc);
    }
}

class CoffeeReturn {

        public double CoffeeCode(double code) {
            double price = 0.0;
            if (code == 1101101) {
                price = 1.99;
            }
            return price;
        }

        public String CoffeeDesc(double code) {
            String desc = "Black Coffee w/ Sugar";
            if (code == 1101101) {
                return desc;
            }
            else
            {
                return "Invalid code";
            }
        }
    }