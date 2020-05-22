// your imports

public class MultiBuy {

    public static int clicked;
    public static double DiscountAmt = 0.05;
    public static double Discount_PRICE_Vodka = 0.385;
    public static double NewVodkaPrice;

    public static void MultiBuy(){
        POS.POS_System.btnVodkaPressed = true;
        System.out.println("No Cases Ran");

        // initialize clicked!!!! 

        clicked = 3;

        switch(clicked){
            case 0:
            clicked++;
            System.out.println("Case 1 Completed");
            break;

            default: 
             txtBill.setText(txtBill.getText() + "\n" +
                    "     " + strPreviousDrink + 
                    spaces(40 - strPreviousDrink.length()) + "-" +
                    PRICE_FORMAT.format(nPreviousPrice) + "\n" +  "     (Canceled)\n");
                nTotal -= nPreviousPrice + NewVodkaPrice;
                btnCancelPrevious.setEnabled(false);
                NewVodkaPrice = Vodka - Discount_PRICE_Vodka;
                POS.POS_System.txtBill.setText(POS.POS_System.txtBill.getText() + "\n" + "Multibuy Special = " + MultiBuy.Discount_PRICE_Vodka);
                POS.POS_System.txtBill.setText(POS.POS_System.txtBill.getText() + "New Price = " + NewVodkaPrice);
                POS.POS_System.nTotal = POS.POS_System.nTotal;
                clicked--;
                System.out.println("Case 2 Completed");//Should equal 3
            break;
        }
    }
}