int maleCount = 0;
int femaleCount = 0;
for (int i = 0; i < name.length; i++)
{
    int index = i;
    System.out.println("Enter name of applicant and gender:");
    System.out.println("M for male and F for female");
    name[index] = myVar.nextLine();

    if (name[index].contains("M")) {
        maleCount++;
    } 
    else if (name[index].contains("F")) {
        femaleCount++;
    }
}

System.out.println("NUMBER OF MALE: " + maleCount);
System.out.println("NUMBER OF FEMALE: " + femaleCount);