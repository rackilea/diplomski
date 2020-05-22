double[] arr1 = {100.00, 100.00, 17246.40, 2568.00, 0.20, 9845.00, 5768.18, 0.20, 30.00, 63.68, 83.56, 444.39, 144.20, 
                2889.00};


double[] arr2 = {2000.90, 508.07, 100.00, 17246.40, 5899.38, 17246.40, 17246.40, 2568.00, 83.56, 144.20, 2889.00, 3000.00, 
                2568.00, 60.00, 3135.00, 28329.91, 3135.00, 9845.00};

Set<Double> set = new HashSet<Double>();

for(int i=0;i<arr1.length;i++){

     for(int j=0;j<arr2.length;j++){
           if(arr1[i]==arr2[j])
                set.add(arr1[i]);
     }
}

System.out.println(Arrays.toString(set.toArray()));