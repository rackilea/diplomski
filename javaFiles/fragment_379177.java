String str = "star wars";
String[] arr = {"star war","Star War","Starwars","star wars","pirates of the caribbean","long strage trip","drone","snatched (2017)"};
for(String s: arr){
    if(str.contains(s))
        System.out.println(s);
}