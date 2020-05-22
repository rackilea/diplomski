List<FileDetail> fileDetails = new ArrayList<FileDetail>();
while ((line = br.readLine()) != null)
    {            
        FileDetail file = new FileDetail();
        println "$line" // This output is given at the end
        // parse - use space delimiter and String.split() API
        String[] strs = line.split(" ");
        // set values to "file"
        // add to list
        fileDetails .add(file);
    }
 return fileDetails;