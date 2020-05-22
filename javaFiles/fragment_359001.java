List<Double> doubleDTList = new ArrayList<Double>();

 while ((line = br.readLine()) != null) {

     // Other Stuff's
     System.out.println(price_split[0]);
     try{
          doubleDTList.add(Double.parseDouble(price_split[0]));
     } catch(NumberFormatException e){
     }

}