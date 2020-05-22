public class NewtonResult {
    int x;
    int iters;
    boolean converged;
    NewtonResult (int x, int iters, boolean converged) {
        this.x = x;
        this.iters = iters;
        this.converged = converged;
    }
}