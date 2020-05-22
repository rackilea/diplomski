private static boolean containsCheck(int[][] twoDm, int ticket) {
        // TODO Auto-generated method stub
        boolean flag = false;
// added another for loop, and changed "equals" to == since the values are int
        for (int[] oneDm : twoDm) {
            for (int individualSeat : oneDm) {
                if (individualSeat == ticket) {
                    flag = true;
                }
            }
        }
        return flag;
    }