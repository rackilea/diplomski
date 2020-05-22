int count = 0;
...
Timer timer = new Timer(1000, new ActionListener(){
    @Override
    public void actionPerformed(ActionEvent e){
        if (count == 30) {
            ((Timer)e.getSource()).stop();
        } else {
            int rand = (int) (Math.random()* RandomNames.size);   
            stars.setText(RandomNames.list.get(rand));
            count++;
        }
    }
});
timer.start();