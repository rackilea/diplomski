public JTabbedPane getTabbedPane() {
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("DayGui", new DayGui());
        tabbedPane.addTab("OfficeCalc", new OfficeAreaCalculator());
        return tabbedPane;
}