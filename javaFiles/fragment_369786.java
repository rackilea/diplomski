// n = count of rows
for(int i=0; i<n; i++)
{
    double[] v = new double[n*m];
    for(int j=0; j<m; j++)
        v[i*n + j] = A[i][j];
    constraints.add(new LinearConstraint(v, Relationship.LEQ, L));
}