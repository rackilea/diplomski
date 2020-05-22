int wasBefore = 0; //are you allowed to use boolean variables?
for (int customer_count3 = 0;
       customer_count3 < customer_count;
       customer_count3++) {                         
    if (customer_Total == customerID[customer_count3]) {
      wasBefore = 1;
    }
}
if (wasBefore==1) {continue;}