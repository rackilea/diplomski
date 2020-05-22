public class ActionB {

  private int m;
  private Stage stage;

  public ActionB() {
      stage = new Implementations.First(this);
  }
  public void proceed() {
      if (stage != null) {
          stage = stage.proceed();
      }
  }

  public abstract class Stage {
    public abstract Stage proceed();
    ActionB outer() { return ActionB.this; }
  }
  static class Implementations {

      public static class First extends Stage {
          First(ActionB outer) { outer.super(); }

          @Override
          public Stage proceed() {
              outer().m = 100;
              return new Second(outer());
          }
      }

      public static class Second extends Stage {
          Second(ActionB outer) { outer.super(); }

          @Override
          public Stage proceed() {
              //do something
              return null; // last stage
          }
      }
  }
}