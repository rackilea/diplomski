public String showForm() {
  // Note the initialization with null!
  Model theModel = null;
  Student student = new Student();
  theModel.addAttribute("student", student);
  return "student-form";
}