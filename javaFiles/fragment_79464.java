IloCplex cplex = new IloCplex();
int i = 0;
this.rl = new double [(int)Data.Count+1];  
IloLinearNumExpr obj = cplex.linearNumExpr();
for(int Pnr = 0; Pnr <= Data.PCount; Pnr++)
    {
     if(Data.X[Pnr]==1)
      {
          IloNumVar x = cplex.boolVar(); 
          obj.addTerm(Data.RL[Pnr], x);
          this.rl[i++] = Data.RL[Pnr]; 
        }
    }
cplex.addMaximize(obj);