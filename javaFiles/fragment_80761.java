abstract class AbstractComplicatedBuilder<B extends AbstractComplicatedBuilder<B>> 
                         extends MyBuilder {
    public final Parameter<B, Long> par1 = new Parameter<>(self());
    public final Parameter<B, Long> par2 = new Parameter<>(self());

    abstract B self();
}

class ComplicatedBuilder extends AbstractComplicatedBuilder<ComplicatedBuilder>{
    ComplicatedBuilder self(){
        return this;
    }
}