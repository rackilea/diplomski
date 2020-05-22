boolean needsToConsider = false;
        int countOfLines = 2; 
        while ((line = bufferedReader.readLine())!= null) {

            if(needsToConsider && countOfLines > 0){
                // add here
                countOfLines--;
                if(countOfLines == 0)
                    needsToConsider = false;
            }
            //pokial obsahuje string zapíš do array
            if (line.toLowerCase().contains("list c.")) {
                parsedData.add(line);
            }
            if(line.toLowerCase().startsWith("re")) {
                parsedData.add(line);//add found data to array
                //i need to access and save second and third line after this one
                needsToConsider = true;
            }