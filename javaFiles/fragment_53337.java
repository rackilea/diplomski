import akka.stream.Attributes;
import akka.stream.FlowShape;
import akka.stream.Inlet;
import akka.stream.Outlet;
import akka.stream.stage.AbstractInHandler;
import akka.stream.stage.GraphStage;
import akka.stream.stage.GraphStageLogic;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;

public class RecordGrouper<T> extends GraphStage<FlowShape<T, List<T>>> {

  private final Inlet<T> inlet = Inlet.create("in");
  private final Outlet<List<T>> outlet = Outlet.create("out");
  private final FlowShape<T, List<T>> shape = new FlowShape<>(inlet, outlet);

  @Override
  public GraphStageLogic createLogic(Attributes inheritedAttributes) {
    return new GraphStageLogic(shape) {
      List<T> batch = new ArrayList<>(3);

      {
        setHandler(
            inlet,
            new AbstractInHandler() {
              @Override
              public void onPush() {
                T record = grab(inlet);
                batch.add(record);
                if (batch.size() == 3) {
                  emit(outlet, ImmutableList.copyOf(batch));
                  batch.clear();
                }
                pull(inlet);
              }
            });
      }

      @Override
      public void preStart() {
        pull(inlet);
      }
    };
  }

  @Override
  public FlowShape<T, List<T>> shape() {
    return shape;
  }
}