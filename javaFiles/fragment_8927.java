public static double[] obtainTs (int comp, int p0, int p1, int p2) {
    double a = p0 - 2*p1 + p2;
    double b = 2*p1 - 2*p0 ;
    double c = p0 - comp;

    double t1 = (-b + Math.sqrt(b*b - 4*a*c)) / (2*a);
    double t2 = (-b - Math.sqrt(b*b - 4*a*c)) / (2*a);

    return new double[] {t1, t2};
}