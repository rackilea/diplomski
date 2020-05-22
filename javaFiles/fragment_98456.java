int leapYears = raw / 4;
int nonLeapYears = 0;    
if ( raw >= 100 )
  {
    nonLeapYears = raw / 100;
    leapYears = leapYears - ( nonLeapYears - ( nonLeapYears / 4 ) );
  }
  else
  {
    nonLeapYears = 0;
  }