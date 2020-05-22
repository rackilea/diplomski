public static double[] getBonusAmt(boolean[] bonusEligibility, int[]  numYrsFlown) {  
    double[] bonusAmt = new double[bonusEligibility.length];    
    for (int i = 0; i < bonusEligibility.length; i++) {           
        if (numYrsFlown[i] >= 9 && bonusEligibility[i]) {
           bonus = 2410.00;
        }
        else if (numYrsFlown[i] < 9 && numYrsFlown[i] >= 6 && bonusEligibility[i]) {
           bonusAmt[i] = 1206.00;
        }
        else if (numYrsFlown[i] < 6 && numYrsFlown[i] >= 2 && bonusEligibility[i]) {
           bonusAmt[i] = 515.00;
        }
        else if (numYrsFlown[i] < 2 && bonusEligibility[i]) {
           bonusAmt[i] = 0.00;
        }                         
    }      
    return bonusAmt; 
}