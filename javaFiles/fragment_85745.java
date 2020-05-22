public static void main(String[] args){
            int target = 99999;
            revised(target);
    }

private static double findSum(double target, double divisor){
            double upperBound = target/divisor;
            System.out.println("|"+upperBound+"|"+target+"|"+divisor);
            return divisor*(upperBound+1)*upperBound*.5;
    }

private static void revised(double target){
            double sumOne = findSum(target, 3);
            double sumTwo = findSum(target, 5);
            double sumThree = findSum(target, 15);
            System.out.printf("%.0f  \n", sumOne + sumTwo - sumThree);
            System.out.println("|"+sumOne+"|"+sumTwo+"|"+sumThree);
    }