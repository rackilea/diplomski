System.out.println("What is your Gender?");
String gender = input.nextLine();
if (gender.equals ("male")){
    System.out.println("What is your age?");
    int agem = input.nextInt();
    if (agem >= 21 && agem < 65){
        System.out.println("Access Granted");
    }else{
        System.out.println("Access Denied");
    }
} else if (gender.equals ("female")){
    System.out.println("What is your age?");
    int agef = input.nextInt();
    if (agef >=18 && agef < 60){
        System.out.println("Access Granted");
    }else{
        System.out.println("Access Denied");
    }
} else {
    System.out.println("Unrecognized input.");
}