List<Map<String, String>> files = new ArrayList<Map<String, String>>()
    while ((line = br.readLine()) != null) {
            Map<String, String> file = new Map<String, String>()       
            String[] strs = line.split(" ")        
            // Find the order of fields, but it is system dependent, may not work in futrue           
            file.add("PERMISSIONS", strs[0]); // and so on for next and you may need to trim map value 
            files.add(file);
            println "$line"
    } 
return files;