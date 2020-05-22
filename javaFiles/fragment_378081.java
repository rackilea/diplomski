a = x.nextDouble();
b = x.nextDouble();
c = x.nextDouble();
if (set.add(a)) {
    A=new Matrix(new double[][]{{a},{b},{c}});
    A.print(9,6)
}