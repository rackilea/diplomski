try{
    if(input.nextInt()!='a')
    {
      arr[i] = input.nextInt();
    }
}catch(InputMismatchException e){
    //here you can get error message using 'e' or you can print custom error as your wish.
    System.out.println("Finished!");
}