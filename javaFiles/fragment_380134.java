try {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = null;
        while ((line = reader.readLine()) !=null) {
            for(int i=0; i<line.length();i++){
                if(line.charAt(i) == character){
                    count++;
                }
            }
        }
    } catch (FileNotFoundException e) {
        // File not found
    } catch (IOException e) {
        // Couldn't read the file
    }