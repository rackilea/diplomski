c = (char) reader.read();
while (c!='\n') {
    int x = 1+i;
    char[] cbuf = new char[x];
    cbuf[i] = c;

           if (cbuf[i]==array[0]){
           counta++;
           }
           if (cbuf[i]==array[1]){
           countb++;
           }
           if (cbuf[i]==array[2]){
           countc++;
           }
           if (cbuf[i]==array[3]){
           countd++;
           }
      System.out.println(cbuf);

            i++;

    c = (char) reader.read(); //read once on every iteration

    }