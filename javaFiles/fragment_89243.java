try{
        short choice1 = Short.parseShort(br.readLine());
}catch(NumberFormatException ex){
    System.out.println("Would you like to change your battle item?"
        + "\n[1] Yes"
         + "\n[2] No");
}