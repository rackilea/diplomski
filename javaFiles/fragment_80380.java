public enum Subjects {
    SOFT_COMPUTING("Soft Computing", pdfviewactivity.class),
    WEB_ENGINEERING("Web Engineering", pdfweben.class),
    NETWORK_MANAGEMENT("Wireless Network", pdfnetwork.class),
    WIRELESS_NETWORK("Network Management", pdfwireless.class);

    private String name;
    private Class clazz;

    Subjects(String name, Class clazz){
        this.name = name;
        this.clazz = clazz;
    }

    public static Class getClass(String title_subject) {
        for(Subjects subject: Subjects.values()) {
            if (subject.name.equals(title_subject)) {
                return subject.clazz;
            }
        }
        return null;
    }
}

private void goToNextView() {

    //Alternative to conditionals using Enum
    Class theClassToGoTo = Subjects.getClass(title_subjects[0]);
    Intent intent = new Intent(ActivityBookDetails.this, theClassToGoTo);
    startActivity(intent);

   //Alternative to conditionals using HashMap
    Map<String, Class> subject_map = new HashMap<>();
    subject_map.put("Soft Computing", pdfviewactivity.class);
    subject_map.put("Web Engineering", pdfweben.class);
    subject_map.put("Wireless Network", pdfnetwork.class);
    subject_map.put("Network Management", pdfwireless.class);

    Class theClassToGoTo2 = subject_map.get(title_subjects[0]);
    Intent intent2 = new Intent(ActivityBookDetails.this, theClassToGoTo2);
    startActivity(intent);
}