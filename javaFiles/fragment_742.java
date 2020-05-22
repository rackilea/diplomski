double avg=0;
int numHourlies = 0; //number of hourlyEmps you have found so far

for(int i=0; i < Emp.length; i++) 
{
      if (Emp[i] instanceof HourlyEmp)
      {
          //just add up all the values for now ...
          avg += Emp[i].totalsal(); 

          //we have found another HourlyEmp, so we increase our count
          numHourlies ++;
      }
}

// ... and calculate the average by dividing the sum by the number of values
avg /= numHourlies; 

System.out.println("Average="+avg);