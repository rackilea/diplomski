public class MainTSP {

    static IloNumVar[][][] buildModel(IloMPModeler model, Data data, IloNumVar[][][] w) throws IloException{

        p15 = new IloIntVar[n][n][n];           
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                for(int q=0; q<n; q++){
                    p15[i][j][q] = model.intVar(lb, ub);
                }
            }
        }
        return p15;
[...]