@Scheduled(cron="0 2 * * * *")
public void sendDailyReportEmail()  {

    Query query = session.createQuery(
        "select distinct m.timezone from Member m");
    List<String> timezones = query.list();

    for (String timezone : timezones) {
        DateTime now = new DateTime(DateTimeZone.forID(timezone));
        if (now.getHourOfDay() == 3) {
            Query query2 = session.createQuery(
                "from Member where timezone = :zone");
            query2.setParameter("zone", timezone);
            List<Member> members = query2.list();
            // send email reports
        }
    }
}