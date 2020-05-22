public void clearReportStudent(Report report) {
  if(report != null) {
    Student student = report.getStudent();
    if(student != null) {
      student.getReports().remove(report);      
      report.setStudent(null);
    }
  }
}