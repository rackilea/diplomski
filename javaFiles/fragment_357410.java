public class CategoryEditor extends PropertyEditorSupport {

    // Converts a String to a Category (when submitting form)
    @Override
    public void setAsText(String text) {
        Category c = new Category();
        c.setName(text);
        this.setValue(c);
    }

    // Converts a Category to a String (when displaying form)
    @Override
    public String getAsText() {
        Category c = (Category) this.getValue();
        return c.getName();
    }

}