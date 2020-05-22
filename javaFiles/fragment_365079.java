int dollar,pieceOfChocolate,voucher,dollar2,voucher2,pieceOfChocolate2;
    Scanner in = new Scanner(System.in);
    System.out.println("How much dollar do you have");

     dollar = in.nextInt();
    // voucher=
     pieceOfChocolate=dollar;
     voucher=pieceOfChocolate;
     pieceOfChocolate=dollar+voucher/6;
     voucher = voucher%6;
    System.out.println("you have  "+pieceOfChocolate+" chocolates and remaining voucher "+voucher);

    boolean ciclo = true;

    while(ciclo){

        System.out.println("How much dollar do you have");

        dollar2 = in.nextInt();
        pieceOfChocolate=dollar2;
     voucher = voucher+pieceOfChocolate;
     pieceOfChocolate=dollar2+voucher/6;
     voucher = voucher%6;

     if(voucher==0)
         break;

       System.out.println("you have  "+pieceOfChocolate+" chocolates and  remaining voucher "+voucher);
       }