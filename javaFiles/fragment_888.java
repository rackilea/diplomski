String names[] = new String[10];
int numbr[] = new int[10];
    for(int i = 0; i<names.length;  i++){
        String line = reader.readLine();
        if(line != null){
            names[i] = line.split(" ")[0];
            numbr[i] = Integer.parseInt(line.split(" ")[1]);

        }


    }