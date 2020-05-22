public static boolean isValidResult(ArrayList<Integer> score, int selectedPoints)
{
    return canMakeValid(score, selectedPoints, 0, 0); // first 0 is for masking, second 0 is for summation.
}

public static boolean canMakeValid(ArrayList<Integer> score, int selectedPoints, int mask, int sum) 
{
    if(sum > selectedPoints) return false;
    sum %= selectedPoints;
    int sz = score.size();
    if(mask == ((1<<sz)-1)) {
        if(sum == 0) return true;
        return false;
    }
    boolean ret = false;
    for(int i = 0; i < sz; i++) {
        if((mask&(1<<i)) == 0) {
            ret = ret | canMakeValid(score, selectedPoints, mask | (1<<i), sum + score.get(i));
        }
    }
    return ret;
}