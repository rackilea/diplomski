for (int i=0; i<x.length-1;i++) {
            d = (float) (d + (Math.pow((x[i+1] - x[i]),2)));
        }

        for (int i=0; i<y.length-1;i++) {
            e = (float) (e + (Math.pow((y[i+1] - y[i]),2)));
        }