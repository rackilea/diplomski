public class ClusterRandom{

    Random dice = new Random();
    int mRange;
    int mWidth = 1;
    int mMean;

    public ClusterRandom(int range, int startingMean, int...width){
        mRange = range;
        mMean = startingMean;
        if(width.length > 0) 
            mWidth = width[0];
    }

    public int nextInt(){

        int pick;        

        do{
              pick = (int) Math.round((dice.nextGaussian()*mWidth) + mMean);     
        }while(pick < 0 || pick >= mRange);

        mMean = pick;
        return pick;

    }

}