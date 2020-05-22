public class Action {

  private int m;
  private Stage stage;

  public Action() {
      stage = new Stage(StageImpl.FIRST);
  }
  public void proceed() {
      if (stage != null) {
          stage = stage.proceed();
      }
  }

  public class Stage {
    final StageImpl stage;
    Stage(StageImpl next) {
      stage=next;
    }
    public Stage proceed() {
      StageImpl next=stage.proceed(Action.this);
      return next==null? null: new Stage(next);
    }
  }
  enum StageImpl {
    FIRST {
      @Override
      StageImpl proceed(Action a) {
        a.m = 100;
        return SECOND;
      }
    },
    SECOND {
      @Override
      StageImpl proceed(Action a) {
        //do something
        return null; // last stage
      }
    }
    ;
    abstract StageImpl proceed(Action a);
  }
}