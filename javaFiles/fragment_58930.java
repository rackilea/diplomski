int[][] stuGrades = {{97, 64, 75, 100, 21}}; //extract from data file

double[][] stuGpa = new double[stuGrades.length][stuGrades[0].length];

String[][] HWdata; // original data file
for (int g = 0; g < stuGrades.length; g++) {
    for (int p = 0; p < stuGrades[0].length; p++) {
        int tempScores = stuGrades[g][p];
        if (tempScores <= 100 && tempScores > 98.1) {
            stuGpa[g][p] = 4.0;
        } else if (tempScores <= 98 && tempScores > 96.1) {
            stuGpa[g][p] = 3.9;
        }
     }
}