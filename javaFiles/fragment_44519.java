String currentLine = "";
BufferedReader bufferedReader = new BufferedReader(fileReader);
    while ((tempLine = bufferedReader.readLine())!= null){
        if (tempLine.isEmpty() == false ){
            currentLine = currentLine+tempLine+"\n";
        }
    }