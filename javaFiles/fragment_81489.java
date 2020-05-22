Scanner szKeyboard = new Scanner(System.in);
Scanner iKeyboard = new Scanner(System.in);

System.out.print("How many of your GCSE subjects do you enjoy? ");
int iSubject = iKeyboard.nextInt();

String[] subjectArr = new String[iSubject];

for(int i=1; i<=iSubject; i++)
{
    System.out.print("Enter subject " + i + ": ");
    subjectArr[i-1] = szKeyboard.nextLine();
}

for(String subject : subjectArr)
{
    System.out.println("Subject yadayada: " + subject);
}