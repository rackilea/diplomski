public static Question[] readAllQuestions() throws FileNotFoundException
{
    int numberOfQuestions = countQuestions();
    Question [] allQuestions = new Question[numberOfQuestions];
    Scanner file = new Scanner (new File("testBank.txt"));
    try
    {      
        for (int i = 0 ; i < allQuestions.length ; i++)
        {
            String text = file.nextLine();
             String q = "";
            while(text.equals(" ")){
                file.nextLine();
            }
            q += text;
            file.nextLine();
            String a=file.nextLine();
            file.nextLine();
            String b=file.nextLine();
            file.nextLine();
            String c=file.nextLine();
            file.nextLine();
            String d=file.nextLine();
            file.nextLine();
            String cA=file.nextLine();
            file.nextLine();
            Question question = new Question(q,a,b,c,d,cA);
            allQuestions[i] = question;
        }
    }
    catch(NoSuchElementException e)
    {
        //Found End of File
    }
    return allQuestions;
}