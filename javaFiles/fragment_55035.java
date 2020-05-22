int output = 0;
    for(int i=0; i<contestant; i++){
        for(int t=0; t<judge; t++){
            output+= allPoints[t][i];  //It has a chance to be  allPoints[i][t] according how  you generate allPoints
        }
        Sum[i] = output;
        output = 0;
    }