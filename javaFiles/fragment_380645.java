g2d.drawImage(
    img,
    model.getFirstCardX() + x * model.getCardDistance() + x * model.getCardWidth(), 
    model.getFirstCardY() + y * model.getCardDistance() + y * model.getCardHeight(), 
    model.getCardWidth(), 
    model.getCardHeight(),
    null);