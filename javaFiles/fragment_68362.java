str = "Abc=1,gdf=1,ghj=1,pqr=1";
String[] arr = str.split(",");
for(String member: arr) {
    if(member.contains("pqr")) {
        //Do your operation here
    }
}