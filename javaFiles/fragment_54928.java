public static void main(String[] args) {
    Scanner sc1 =new Scanner(System.in);
    Scanner sc2 =new Scanner(System.in);
    System.out.println("1\tCompact: 650 € per m²\n2\tOptimal: 700 € per 
    m²");
    System.out.println("Please choose your 1 for Compact and 2 for product");
    int swichValue=sc1.nextInt();
    Summe hs=new Summe(); 
    // set the values here manually as you described
    hs.setLivingSpace (0.5); // or whatever value, you may need to take it from user..etc 

    switch(swichValue){
    case 1:
          double res=hs.KompaktSumme();
          System.out.println("Versicherungssumme ist : "+res);
       break;

    case 2:
          double res=hs.OptimalSumme();
          System.out.println("Versicherungssumme ist : "+res);
        break;

    case 3:
         System.out.println("Error");
    }
}