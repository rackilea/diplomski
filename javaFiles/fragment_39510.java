package testJOptimizer;

import com.joptimizer.functions.ConvexMultivariateRealFunction;
import com.joptimizer.functions.LinearMultivariateRealFunction;
import com.joptimizer.optimizers.JOptimizer;
import com.joptimizer.optimizers.OptimizationRequest;

/**
 *
 * @author K.P.L.Kanchana
 */
public class test_4_alternateOptimum {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
//        BasicConfigurator.configure();

        // Objective function (plane)
        LinearMultivariateRealFunction objectiveFunction = new LinearMultivariateRealFunction(new double[] {-4.0, -3.0}, 0); // maximize 4x+3y

        //inequalities (polyhedral feasible set G.X<H )
        ConvexMultivariateRealFunction[] inequalities = new ConvexMultivariateRealFunction[4];
        // 8x+6y < 25(no equal sign)
        inequalities[0] = new LinearMultivariateRealFunction(new double[]{8.0, 6.0}, -25); // 8x+6y-25<0
        // 3x+4y < 15
        inequalities[1] = new LinearMultivariateRealFunction(new double[]{1.0, 4.0}, -15); // 3x+4y-15<0
        // x > 0
        inequalities[2] = new LinearMultivariateRealFunction(new double[]{-1.0, 0.0}, 0);
        // y > 0
        inequalities[3] = new LinearMultivariateRealFunction(new double[]{0.0, -1.0}, 0);

        //optimization problem
        OptimizationRequest or = new OptimizationRequest();
        or.setF0(objectiveFunction);
        or.setFi(inequalities);
        //or.setInitialPoint(new double[] {0.0, 0.0});//initial feasible point, not mandatory
        or.setToleranceFeas(JOptimizer.DEFAULT_FEASIBILITY_TOLERANCE / 10); // There was the issue
        or.setTolerance(JOptimizer.DEFAULT_TOLERANCE / 10);  // There was the issue

        //optimization
        JOptimizer opt = new JOptimizer();
        opt.setOptimizationRequest(or);
        try {
            int returnCode = opt.optimize();
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return;
        }

        // get the solution
        double[] sol = opt.getOptimizationResponse().getSolution();

        // display the solution
        System.out.println("Length: " + sol.length);
        for (int i = 0; i < sol.length; i++) {
                System.out.println("answer " + (i+1) + ": " + (sol[i]));
        }
    }

}