public getQandAPanel(){
    JPanel questPanel = new JPanel();
    JPanel answerPanel = new JPanel();
    JPanel wrappingPanel = new JPanel();
    wrappingPanel.setLayout(new GridLayout(0,1));
    //CODE TO DECORATE question and answer panels should go here
    wrappingPanel.add(questPanel);
    wrappingPanel.add(answerPanel);
}