protected CCSprite ship;

public void update(float dt){
    for (CCSprite target : _targets){
        CGRect targetRect = CGRect.make(target.getPosition().x - (target.getContentSize().width), target.getPosition().y - (target.getContentSize().height), target.getContentSize().width,target.getContentSize().height);
        System.out.println("shipstodelete : " + ship);
        CGRect shipRect = CGRect.make(ship.getPosition().x - (ship.getContentSize().width), ship.getPosition().y - (ship.getContentSize().height), ship.getContentSize().width,ship.getContentSize().height);
        if (CGRect.intersects(targetRect, shipRect)){
            this.removeChild(ship, true);
            //removeChild(ship, true);
        }
    }
}
...

public void someOtherMethodYouDontMention(){
    //Notice I set the previously declared ship value not a new ship value
    ship = CCSprite.sprite("ship150.png");
    ship.setPosition(CGPoint.ccp(25,100));
    ship.setAnchorPoint(CGPoint.ccp(0,0));
    ship.setTag(4);
    addChild(ship);
}