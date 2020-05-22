RobotiserEffect robotiserEffect = new RobotiserEffect();
robotiserEffect.setParams("amount:100");
StadiumEffect stadiumEffect = new StadiumEffect();
stadiumEffect.setParams("amount:100");
mary.setAudioEffects(robotiserEffect.getFullEffectAsString() + '+' + 
    stadiumEffect.getFullEffectAsString());