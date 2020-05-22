//output total usage
System.out.printf("your usage was: %.1f KwHs", totalUsage(prevMeter, currMeter));

//calculate rate        
if (totalUsage(prevMeter, currMeter) < 500.0) {
    rate = .0809;
}
else if (totalUsage(prevMeter, currMeter) > 500.0 && totalUsage(prevMeter, currMeter) < 900.0){
    rate = .091;
}
else {
    rate = .091;
}

//output rate   
System.out.printf("\nYour rate was: %.4f/KwH", rate);