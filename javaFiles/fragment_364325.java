String keyword = "filename: ";
String[] files = example.split("\\r?\\n");
for(String file : files) {
    if(file.startsWith(keyword)){
        System.out.println(file.substring(keyword.length()));
    }
}