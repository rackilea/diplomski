public interface MainFragmentComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder mainFragmentView(MainFragmentView mainFragmentView);
    }
    void inject(MainFragment mainFragment);
}