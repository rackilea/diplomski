for(j = 0; j < 36; j++){ 
        System.out.println("Card:" + j + " Index:" + j);
        int indexOfCard = j;
        cardInfo[j].addMouseListener(new MouseAdapter(){
        @Override 
        public void mouseClicked(MouseEvent e){ 
                System.out.println("Index Given:" + indexOfCard);
                makeCard(indexOfCard);
                }
        });
}