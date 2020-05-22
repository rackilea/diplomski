String results = readFromString(data);

StringBuilder output = new StringBuilder();
for(String[] sArray : results) {
    for(String s : sArray) {
        output.append(s);
    }
}

System.out.println(output);