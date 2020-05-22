int i=0;
 while((line = br.readLine()) != null) {
        StringTokenizer st = new StringTokenizer (line);
        int num=0;
        //the next line is when you need to calculate the number of columns
        //otherwise leave blank
        matrix[i]=new int[st.countTokens()];
        while (st.hasMoreTokens()){
            int value1 = Integer.parseInt(st.nextToken());
            matrix[i][num] = value1;
            num++;              
        }
        i++;
 }