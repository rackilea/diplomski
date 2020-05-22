for (int i=0; i<x.length-1;i++) {
            float temp;

            temp = (Math.pow((x[i+1] - x[i]),2)) + (Math.pow((y[i+1] - y[i]),2));

            d = (float) (d + sqrt(temp));
        }

// for first and last values /  coordinates w.r.t distance formula
for (int i=x.length-1; i<x.length;i++) {
        float temp;

        temp = (float) ((Math.pow((x[i] - x[0]),2)) + (Math.pow((y[i] - y[0]),2)));

        d = (float) (d + Math.sqrt(temp));
    }