System.out.println("Ditt val: "+ prov.GetCategoryName(nVal-1));
cat = prov.GetCategory(nVal-1);
int nCorrectAnswers = 0;

for(int i = 0; i < cat.nNumQuestions; i++){
    System.out.print(cat.taskArray[i].sQuestion +": ");
    String nMyAnswer = scan.next();

    if(nMyAnswer == 1){
        nCorrectAnswers++;
    }
}