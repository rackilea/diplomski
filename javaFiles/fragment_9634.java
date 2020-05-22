public static int move(int number, char start, char help, char end,int count){
    if(number == 1){
        print("Move the top disk from " + start + " to " + end);
        assert count == 1; 
        return 1;
    }else{
        int subCount1 = move(number-1,start,end,help, (count-1)/2);
        print("Move the top disk from " + start + " to " + end);
        int subCount2 = move(number-1,help,start,end, (count-1)/2);
        assert count == (subCount1 + subCount2 + 1);
        return count; // it's the same as returning 2*f(n-1)+1;
    }
}