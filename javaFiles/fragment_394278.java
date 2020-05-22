if(maxAttempts.hasNextInt()){ // this will check if there is an integer to read from scanner 
       processMaxAttempts = maxAttempts.nextInt();
} else {
       processMaxAttempts2 = maxAttempts.nextLine();
}

if(processMaxAttempts2!=null && processMaxAttempts2.equals("unlimited")){
    System.out.println("unlimited");
}else{
    System.out.println("set");
}