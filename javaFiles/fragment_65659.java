for (int k=0; k<N; k+=1000) {
       final int datapoint=k;
       executor.execute(new Runnable() {
           processDataRange(datapoint, datapoint+1000);
       });
    }