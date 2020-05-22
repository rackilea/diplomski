//Maps movie IDs to occurrences
Map<String,Int> movieMap = new HashMap<>();
//In here is the list of movie IDs for each word
for(String val : values) {
    if(!movieMap.contains(val)) {
        movieMap.put(val,1);
    } else {
        movieMap.put(val,movieMap.get(val)+1);
    }
}
output.write(NullWritable.get(),key+"\t"+movieMap);