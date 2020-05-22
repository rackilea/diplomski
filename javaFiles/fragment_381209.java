final String PENDING = "pending"
    final String ACCEPTED = "accepted"
    final String DELIVERED = "delivered"

  //  Using IF
    if (order_status.equalsIgnoreCase(PENDING)){
      //execute your function according to your status
    }else if(order_status.equalsIgnoreCase(ACCEPTED)){

    }else if (order_status.equalsIgnoreCase(DELIVERED)){

    }

   // using switch case
    switch(order_status.toLowerCase()){
      case PENDING:
      //execute your function according to your status
      break;
      case ACCEPTED:
      break
      case DELIVERED:
       break;
      default:
      System.out.print("Add more cases");
    }