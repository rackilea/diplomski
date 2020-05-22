public class Action {
    private int m;
    private Stage stage;

    public Action() {
        stage = Stage.FIRST;
    }
    public void proceed() {
        if (stage != null) {
            stage = stage.proceed(this);
        }
    }

    enum Stage {
      FIRST {
        @Override
        Stage proceed(Action a) {
          a.m = 100;
          return SECOND;
        }
      },
      SECOND {
        @Override
        Stage proceed(Action a) {
          //do something
          return null; // last stage
        }
      }
      ;
      /**
       * Executes current stage and returns next stage.
       */
      abstract Stage proceed(Action a);
    }
}