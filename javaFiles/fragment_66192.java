class FirstEntityStep implements EntityStep<Entity> {
    @Override
    public void process(EntityStepInput<? extends Entity> i) {}
}
class SecondEntityStep implements EntityStep<Entity> {
    @Override
    public void process(EntityStepInput<? extends Entity> i) {}
}
class ThirdEntityStep implements EntityStep<DerivedEntity> {
    @Override
    public void process(EntityStepInput<? extends DerivedEntity> i) {}
}