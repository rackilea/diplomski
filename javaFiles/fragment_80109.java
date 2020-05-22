public class CustomToolModule {
    public static class Options implements OptionsModule {
        void assignOptions(MyOptionModule optionModule) {
            ...
        }
    }


    public static void main(String[] args) {
        MyOptionsModule optionsModule = MyOptionsModuleFactory.createOptionsModule(
                new CustomToolModule.Options()
        );
    }
}