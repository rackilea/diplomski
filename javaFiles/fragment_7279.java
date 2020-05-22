for(int i=0; i<parts.size(); i++){

    System.out.println("Loop number: "+i);
    System.out.println("Current list: "+parts);         

    Thread.sleep(2000);
    parts.remove(i--);

    System.out.println("After removing: "+parts);
}