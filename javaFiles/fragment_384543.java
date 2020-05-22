public class ConCalInstanceRecord extends org.jooq.impl.UpdatableRecordImpl....{

     //fields and getter and setters of the generated record..

    private ConCalInstanceBehaviour behaviour;

    public ConCalInstanceBehaviour getBehaviour(){
        if(behaviour==null){
            behaviour=new ConCalInstanceBehaviour(this);
        }
        return behaviour;
    }
}