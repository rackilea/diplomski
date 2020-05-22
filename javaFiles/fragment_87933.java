for(String actualClassName : sortedClassNames) {
    System.out.print(actualClassName);
    for(String predictedClassName : sortedClassNames) {
        Integer value = cmatrix.get(actualClassName + "," + predictedClassName);
        System.out.print("\t");
        if(value != null) {
            System.out.print(value);
        }
    }
    System.out.println();
}