int i, j;
    int MDArray[][]=new int [13][13];
    for(i=0; i<13; i++)
        for(j=0; j<13; j++)
            MDArray[i][j]=i*j;
    int index1=(int)(Math.random()*13);
    int index2=(int)(Math.random()*13);



    int answer;
    answer = MDArray[index1][index2];
    System.out.println(index1+"x"+index2+" = "+answer);