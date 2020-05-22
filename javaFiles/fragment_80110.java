public static class CustomToolModule {

    public static void assignOptions(MyOptionsModule optionsModule) {
        ...
    }

    public static void main(String[] args) {
        MyOptionsModule optionsModule = MyOptionsModuleFactory.createOptionsModule(
                CustomToolModule::assignOptions,
                CustomToolModule2::assignOptions
        );
        ...
    }
}