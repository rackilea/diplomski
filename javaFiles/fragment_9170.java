@Override
public List<ViewManager> createViewManagers(
        ReactApplicationContext reactContext) {
    return Arrays.<ViewManager>asList(
            new MyCustomReactViewManager() //Add here.
    );
}