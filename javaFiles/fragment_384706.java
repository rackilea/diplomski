class MinMaxNodeEvaluator implements NodeEvaluator {
    public int evalNode(Board b, depth) {
        // evaluate node using min/max appproach
    }
}

class AlphaBetaNodeEvaluator implements NodeEvaluator {
    private int maxVal;

    public AlphaBetaNodeEvaluator()
    {
        this.maxVal = Integer.MAX_VALUE;
    }

    public int evalNode(Board b, depth) {
        int currentScore = evalNode(b, depth, Integer.MIN_VALUE, -this.maxval);
        this.maxVal = max(currentScore , this.maxVal);
        return currentScore;
    }

    private int evalNode(Board b, int depth, int alpha, int beta) {
        //...
    }

}