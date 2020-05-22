HashMap<String,HashMap<String,String>> sections = new HashMap<>();
BufferedReader br = new BufferedReader(new FileReader(new File(filename)));
String line = "";
HashMap<String,String> actualSection = null;
Pattern p = Pattern.compile("\\[(.*?)\\]"); // regex pattern for brackets
while ((line = br.readLine()) != null) { 
    Matcher m = p.matcher(line);
    if(m.find()){
        // found regex means new section
        actualSection = new HashMap<String,String>();
        sections.put(m.group(1), actualSection);
    } else{
        // read in new key Value pairs
        String[] parts = line.split("=");
        if(parts.length == 2 && actualSection != null){                     
            actualSection.put(parts[0],parts[1]);   
        }                       
    }
}