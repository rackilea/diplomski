private String completeQuery(String coreQuery){
String completeQuery = "";
completeQuery += "SELECT * WHERE {"+ "\n";
completeQuery += coreQuery + "\n";
completeQuery =completeQuery + "}" + "\n" +"limit 5" ;
return completeQuery;}
public String link(String object1, String object2, int distance){
if(distance == 1){
    String Quer = "<http://dbpedia.org/resource/"+object1+">" + " ?pre1 " +"<http://dbpedia.org/resource/"+object2+">";
    return completeQuery(Quer);
} 
else {
    String query = "<http://dbpedia.org/resource/"+object1+">" + " ?pre1 ?obj1 " + ".\n";
    for(int i = 1; i < distance-1; i++){
        query += "?obj" + i + " ?pre" + (i+1) + " ?obj" + (i+1) + ".\n" ;

    }
    query  += "?obj" + (distance-1) + " ?pre" + distance + " " + "<http://dbpedia.org/resource/"+object2+">";
    return completeQuery(query);
}}