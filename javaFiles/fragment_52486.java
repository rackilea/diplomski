float[] x = {1, 2, 3, 4, 5, 1, 7, 8, 10, 10}; // x values

float[] y = {30, 34, 45, 57, 77, 89, 100, 111, 123, 145}; // y values


ListMultimap<Float, Float> test1map = ArrayListMultimap.create();

for( int t =0 ; t < x.length; t++){
        for(int j = 0; j< x.length; j++){
            if (t !=j && x[t] == x[j]){
                y[j] += y[t];

                test1map.removeAll(x[t]);

            }

        }
        test1map.put(x[t], y[t]);


    }
ArrayList<Float> eureka = new ArrayList<Float>();
ArrayList<Float> eureka2 = new ArrayList<Float>();
int b= 0;
for(Float key : test1map.keys()){
    eureka.add(b, key);
    b++;
}
int v = 0;
for(Float value : test1map.values()){
    eureka2.add(v, value);
    v++;
}