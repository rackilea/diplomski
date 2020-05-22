import javax.swing.JLabel;
import javax.swing.JRadioButton;

public class GuiRow {

  /** jRadioButton */
  private JRadioButton jRadioButton;

  /** studentIdLabel */
  private JLabel studentIdLabel;

  /** nameLabel */
  private JLabel nameLabel;

  /** courseLabel */
  private JLabel courseLabel;

  /**
   * Constructs a new instance.
   * 
   * @param studentIdtext
   * @param nameText
   * @param courseText
   */
  public GuiRow(String studentIdtext, String nameText, String courseText) {
    this.setjRadioButton(new JRadioButton(""));
    // TODO configure radio button

    this.setStudentIdLabel(new JLabel(studentIdtext));
    this.setNameLabel(new JLabel(nameText));
    this.setCourseLabel(new JLabel(nameText));
  }

  /**
   * Get jRadioButton.
   * 
   * @return jRadioButton
   */
  public JRadioButton getjRadioButton() {
    return this.jRadioButton;
  }

  /**
   * Set jRadioButton.
   * 
   * @param jRadioButton
   */
  public void setjRadioButton(JRadioButton jRadioButton) {
    this.jRadioButton = jRadioButton;
  }

  /**
   * Get studentIdLabel.
   * 
   * @return studentIdLabel
   */
  public JLabel getStudentIdLabel() {
    return this.studentIdLabel;
  }

  /**
   * Set studentIdLabel.
   * 
   * @param studentIdLabel
   */
  public void setStudentIdLabel(JLabel studentIdLabel) {
    this.studentIdLabel = studentIdLabel;
  }

  /**
   * Get nameLabel.
   * 
   * @return nameLabel
   */
  public JLabel getNameLabel() {
    return this.nameLabel;
  }

  /**
   * Set nameLabel.
   * 
   * @param nameLabel
   */
  public void setNameLabel(JLabel nameLabel) {
    this.nameLabel = nameLabel;
  }

  /**
   * Get courseLabel.
   * 
   * @return courseLabel
   */
  public JLabel getCourseLabel() {
    return this.courseLabel;
  }

  /**
   * Set courseLabel.
   * 
   * @param courseLabel
   */
  public void setCourseLabel(JLabel courseLabel) {
    this.courseLabel = courseLabel;
  }
}