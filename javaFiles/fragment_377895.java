import scala.Function1;
import scala.Tuple2;
import scala.runtime.AbstractFunction1;
import scala.runtime.BoxedUnit;

getStateActor(new AbstractFunction1<Tuple2<ActorRef, Object>, BoxedUnit>() {
    @Override
    public BoxedUnit apply(Tuple2<ActorRef, Object> args) {
        return BoxedUnit.UNIT;
    }
});