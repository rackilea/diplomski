res = conect.prepareStatement("SELECT something FROM historyinsert ORDER BY TID ASC").executeQuery();

ArrayList<String> list= new ArrayList<String>();
while (res.next()) {
    list.add(res.getString("something"));   
} 

String[] result = new String[list.size()];
result = list.toArray(result);

for(int i =0; i<result.length; i++){
    System.out.println(result[i]);
}