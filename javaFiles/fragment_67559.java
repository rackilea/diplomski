case 1:
    System.out.println("Enter the Amount :");
    currentAccount.debit(scanner.nextDouble());
    scanner.nextLine();  // Consume newline left

    System.out.println("Want anything else(yes/no)?");
    String input=scanner.nextLine();

    if(input.equalsIgnoreCase("no")){
        isFinished=true;   
        currentAccount=null;
        System.out.println("SignedOut successfully");  
    }
    break;