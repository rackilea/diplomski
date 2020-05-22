for (File f : files) {
    //This will skip the file if it is a directory
    if (!f.isFile())
        continue;

    System.out.println("File name in directory is: " + f);  
    inputStream = new BufferedReader(new FileReader(f));

    String line;
    try {
        while((line = inputStream.readLine()) != null) {
            //System.out.println("i in while loop" + " " + i); just for checking
             detector.append(inputStream);  
        }
        //i++;
        String lang = detector.detect();
        ArrayList<Language> langlist = detector.getProbabilities();
        System.out.println("Language Detected for input file is" + " " + lang); 
        System.out.println("Probability of language is: " + " " + langlist); 
        inputStream.close();      
    }
    catch(Exception e) {}
}