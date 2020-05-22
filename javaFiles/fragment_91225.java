public class Report {
  public void unlinkFromStudent() {
    if(this.student != null) {
      this.student.getReports().remove(this);
      this.student = null;
    }
  }
}