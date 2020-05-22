List<String> vars = new ArrayList<>();
Template tmpl = ... // compile your template
tmpl.visit(new Mustache.Visitor() {

  // I assume you don't care about the raw text or include directives
  public void visitText(String text) {}

  // You do care about variables, per your example
  public void visitVariable(String name) {vars.add("Variable: " + name); }

  // Also makes sense to visit nested templates.
  public boolean visitInclude(String name) { vars.add("Include: " + name); return true; }

  // I assume you also care about sections and inverted sections
  public boolean visitSection(String name) { vars.add("Section: " + name); return true; }

  public boolean visitInvertedSection(String name) { vars.add("Inverted Section: " + name); return true; }
});