public String test(){
    // code
    final List<String> list = new ArrayList<>();
    button.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            list.add("toBeReturned");
        }
    });
    frame.add(button);
    return list.get(0);
}