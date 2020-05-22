class TimerListener implements ActionListener {
    private CountModel model;

    public TimerListener(CountModel model) {
        super();
        this.model = model;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int oldCount = model.getCount();
        int newCount = oldCount + 1;
        model.setCount(newCount);
    }
}