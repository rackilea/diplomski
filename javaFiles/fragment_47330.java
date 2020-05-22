else if(inf.contains("Main booker") ||  inf.contains("Haupt-Bucher") || inf.contains("Hoofdboeker")){
String[] result = MainBooker(doc, i);  
if(!result[2].equals("-")){              
    informationBasic.add(result[1] +" "+result[2]+ " "+ result[3]);
}
else if(result[2].equals("-")){
    informationBasic.add(result[1] + " "+ result[3]);
}
mainbooker.addAll(Arrays.asList(result));}