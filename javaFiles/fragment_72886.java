HashSet<PrizeCard> prizes = new HashSet<PrizeCard>();
for (int i=0; i<=4; i++) {
    do{
        spun=wheel.spinWheel();
    }while(prizes.contains(spun));
    prizes.add(spun);
}