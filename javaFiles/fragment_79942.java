public class CustomInterpolator extends
    AccelerateDecelerateInterpolator {

    private ICustomInterpolator delegate;

    public <T extends ICustomInterpolator> CustomInterpolator(T delegate) {
        super();
        this.delegate = delegate;
    }

    @Override
    public float getInterpolation(float input) {
        delegate.currentProgress(input);
        return super.getInterpolation(input);
    }
}