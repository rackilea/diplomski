while ((secondLine = br.readLine()) != null) {

        if (secondLine.contains(endOfFirstLine)) {
            bw.write(secondLine+"\n"); 
            break;
        }

        if (secondLine.contains(secondFileLine))
            secondLine = secondLine.replace(secondFileLine, newValue);
        bw.write(secondLine+"\n");  
    }