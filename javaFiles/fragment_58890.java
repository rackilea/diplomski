while(!done){
        junk.seek(y);
        System.out.println("Enter name.");
        junk.writeBytes(sc.nextLine());
        y+=20;
        System.out.println("Enter age.");
        junk.seek(y);
        junk.writeBytes(sc.nextLine());
        y+=20;
        System.out.println("Enter city.");
        junk.seek(y);
        String city=sc.nextLine();
        System.out.println("Are you done?(Y/N)");
        choice = sc.nextLine();
        if(choice.equalsIgnoreCase("Y")){
            if(city.length()>20){city-city.substring(0,20);}
            else if(city.length()<20){city=city+new String(new byte[20-city.length()]);}
            done = true;
        }
        junk.writeBytes(city);
        y+=20;
}