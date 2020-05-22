@Scheduled(cron = "0 0/1 * * * *") 
public void freezeDateTwo(){ 
    System.out.println("shudler Working");
    service.updateFreezeOnDateTwoAndSixteen(); 
    List<ExtusrRole> user = service.getExtUser(); 
    excelReport(user); 
    //In this point you should have created a report in some specific location
}