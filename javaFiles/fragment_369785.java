for(int j=0; j<m; j++)
{
    double[] v = new double[n*m];
    for(int i=0; i<n; i++)
        v[i*n + j] = 1;
    constraints.add(new LinearConstraint(v, Relationship.LEQ, 1));
}