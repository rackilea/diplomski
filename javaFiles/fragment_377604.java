String[] students= {"Adam","Smith","Jones"}; 
int[] adamGrades = {90,92,93};
double gradesTotal = 0.00;
for(int i=0; i < adamGrades.length; i++){
  gradesTotal += adamGrades[i];
}
double avg = (gradesTotal/adamGrades.length);
System.out.print(avg);