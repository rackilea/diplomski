if (input.hasNextInt()) {
    System.out.println(input.nextInt());
}else if(input.hasNextDouble()) {
    System.out.println(input.nextDouble());
}else{
    //Neither int or double
    input.nextLine();
    continue; 
}