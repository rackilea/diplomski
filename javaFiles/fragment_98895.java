int increaseDays = (int) (numberofDays + 0.5) / 2;

int i;
for (i = 1; i <= increaseDays; i++) 
{
    sharePoints += 50;
    System.out.println(i + "  " + sharePoints);
}

for (; i <= numberofDays; i++)
{
    sharePoints -= 25;
    System.out.println(i + "  " + sharePoints);
}