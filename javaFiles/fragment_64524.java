int q = 1;
for(int j=0;j<totalNoOfLOB.size();j++) { 
System.out.print(totalNoOfLOB.get(j).getText());
for(int p=q+1;p<combinedPerformanceOfMeasure.size();p++) {
System.out.print(" " + combinedPerformanceOfMeasure.get(p).getText());
break;
}
System.out.print("\n")
q++;
}