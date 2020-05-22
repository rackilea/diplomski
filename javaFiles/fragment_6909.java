@Scheduled(cron = "0 0 0 * * ?")
public void UpdateFn() {
    try {
        System.out.println("-----------Background Task Running----------------");
        //code to update some data every day
        System.out.println("-----------Background Task Ending----------------");
    } catch (Exception e) {
        e.printStackTrace();
    }
}