public Behavior addBehavior(BehaviorDto behaviorDto, String aptitudeId) {
    Aptitude aptitude;
    aptitude = findById(aptitudeId);
    List<Behavior> behaviors = aptitude.getBehaviors();
    Behavior newBehavior = new Behavior(behaviorDto);
    behaviors.add(newBehavior);
    return newBehavior;
}