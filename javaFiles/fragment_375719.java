IloNumExpr obj = cplex.sum(cplex.prod(pa0, a[0]), 
                             cplex.prod(pa1, a[1]),
                             cplex.prod(pb0, b[0]),
                             cplex.prod(pb1, b[1])); 

    model.add(IloMinimize(env, obj));