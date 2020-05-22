loop: while(sc.hasNextInt()){
    typing = sc.nextInt();
    switch(typing){
        case 0:
          break loop; 
        case 1:
          System.out.println("You choosed 1");
          break;
        case 2:
          System.out.println("You choosed 2");
          break;
        default:
          System.out.println("No such choice");
    }
}