for (int i = 0; i < 10000; i++){
    double d = i / 100.;
    int j = (int)(d * 100.);
    if (i != j)
        System.out.println(i + ": " + j);
}