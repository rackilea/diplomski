public class Solution {
    public int solution(int[] A) {

        boolean possibleSolution = true; // to return and properly break if not possible

        for(int i = 0; i < A.length; i++) // run for all ints
        {
            possibleSolution = true; // set possible true, in case last one failed
            for(int j = 0; j < A.length; j++) // take all ints again (to compare to the rest
                if(A[i] == A[j] && i != j){ // note i escape comparing to itself
                    possibleSolution = false; // if there is a math it can't be this one
                    break; // break to save resources
            }
            if(possibleSolution) // if it's the solution
                return A[i]; // return the current number (from the initial array as that is the reference number and the 2nd is for comparing)

        }
        return 0; // return default
    }

    public static void main(String[] args){
        Solution solution = new Solution(); // instance
        int[] ints = {9,3,9,3,9,7,9}; // new values
        System.out.println(solution.solution(ints)); // print the method after it was run
    }
}