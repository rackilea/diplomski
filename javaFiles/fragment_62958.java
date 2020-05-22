double totalUsage = totalUsage(prevMeter, currMeter);
System.out.printf("your usage was: %.1f KwHs", totalUsage);

//calculate rate        
if (totalUsage < 500.0) {
    rate = .0809;
}
else if (totalUsage > 500.0 && totalUsage < 900.0){
    rate = .091;
}
else {
    rate = .091;
}

//output rate   
System.out.printf("\nYour rate was: %.4f/KwH", rate);