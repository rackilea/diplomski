public class Main {

  public static void main(String[] args) {
    ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("app-context.xml"); //assuming app-context.xml is in classpath of project
    ReportDao reportDao = ctx.getBean(ReportDao.class); //Ask Spring to gice you DAO object with injected dataSource
    List<Report> reports = reportDao.findAll();
    for (Report report : reports) {
        System.out.println("report: " + report.getName());
    }
  }
}