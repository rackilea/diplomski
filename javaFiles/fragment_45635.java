public class CustomFinder extends Finder {
    private Class<? extends ServerResource> targetClass;

    public CustomFinder() {
        super();
    }

    public CustomFinder(Context context) {
        super(context);
    }

    public CustomFinder(Context context,
            Class<? extends ServerResource> targetClass) {
        super(context, targetClass);
        this.targetClass = targetClass;
    }
}