@Subcomponent
public interface MySubComponent {
    @Subcomponent.Builder
    interface Builder {
        @BindsInstance Builder s(S s);
        StatusBarComponent build();
    }

    /**
     * Scope annotation for singleton items within the MySubComponent.
     */
    @Documented
    @Retention(RUNTIME)
    @Scope
    @interface MySubComponentScope {}

    @MySubComponentScope
    Ohter getOther();

}

// Attach MySubComponent to Dagger where appropriate, per their documentation.
// Then, in Main, do something like the following:


class Main {
  private final MySubComponent.Builder mySubComponentBuilder;
  private final S.Builder sBuilder;
  private Foobar foobar;

  @Inject
  public Main(MySubComponent.Builder mySubComponentBuilder, S.Builder sBuilder) {
    this.mySubComponentBuilder = mySubComponentBuilder;
    this.sBuilder = sBuilder;
  }

  // At some point, foobar gets created. Then we call the following method.
  private void afterInit();
    S s = sBuilder.setFoobar(foobar).build();

    Other other = mySubComponentBuilder.s(s).build().getOther();
  }
}