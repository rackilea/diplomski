private static class NationalityMatcherEditor extends AbstractMatcherEditor implements ActionListener {
    private JComboBox nationalityChooser;

    public NationalityMatcherEditor() {
        this.nationalityChooser = new JComboBox(new Object[] {"British", "American"});
        this.nationalityChooser.getModel().setSelectedItem("Filter by Nationality...");
        this.nationalityChooser.addActionListener(this);
    }

    public Component getComponent() {
        return this.nationalityChooser;
    }

    public void actionPerformed(ActionEvent e) {
        final String nationality = (String) this.nationalityChooser.getSelectedItem();
        if (nationality == null)
            this.fireMatchAll();
        else
            this.fireChanged(new NationalityMatcher(nationality));
    }

    private static class NationalityMatcher implements Matcher {
        private final String nationality;

        public NationalityMatcher(String nationality) {
            this.nationality = nationality;
        }

        public boolean matches(Object item) {
            final AmericanIdol idol = (AmericanIdol) item;
            return this.nationality.equals(idol.getNationality());
        }
    }
}