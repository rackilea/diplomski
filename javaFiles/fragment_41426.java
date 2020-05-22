for (int n = 1; n <=50 ; n++)
{
    String out = "";

    quantityIn -= item_1.getDailyDemand();

    out += n;
    out += " " + quantityIn;

    if (n % item_1.getLeadTime() == 1 ){

        out += " Batch Ordered";
    }

    else if (n % item_1.getLeadTime() == 0){

        quantityIn += item_1.getReOrder();
        out += " Batch Received";

    }

    System.out.println(out);

}