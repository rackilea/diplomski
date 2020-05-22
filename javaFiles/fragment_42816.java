public static void main(String... s){
    for(Motorcycle m : Motorcycle.values()){
        if(m.getAbbreviation().equals("Y")){
            System.out.println(m.getColor());
            break;
        }
    }
  }