String[] idAndWords = input.split("\\t");

for(String word : idAndWords[1].split(" ")) {
    //Do whatever cleansing you want here - remove punctuation, lowercase etc.
    output.write(word,idAndWords[0]);
}