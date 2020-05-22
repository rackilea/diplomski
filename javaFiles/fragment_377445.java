int k = 0;
    Double sum = 0.0;//cosine similarity
    Double sum2 = 0.0;
    System.out.println(employeeYearsOfService);
    for (String key : employeeYearsOfService.rowKeySet()) {
        HashMap<String, Double> hm = new HashMap<String, Double>();
        for (Entry<String, Double> employee : 
        employeeYearsOfService.row(key).entrySet()) {
            sum += employee.getValue() * operatCible.get(k);
            sum2+=employee.getValue();
            k++;
        }
        k = 0;

        System.out.println(sum);
        System.out.println("----");
        System.out.println(sqrt(sum2));
        hm.put(key, sum);
        sum = 0.0;

        System.out.println(hm);
    }


}