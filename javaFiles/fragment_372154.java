public abstract class AjaxTimerFormSubmitBehavior extends AbstractAjaxTimerBehavior {

    /**
     * should never be accessed directly (thus the __ cause its overkill to
     * create a super class), instead always use #getForm()
     */
    private Form<?> __form;

    private boolean defaultProcessing = true;

    /**
     * @param updateInterval
     */
    public AjaxTimerFormSubmitBehavior(Duration updateInterval) {
        this(null, updateInterval);
    }

    public AjaxTimerFormSubmitBehavior(Form<?> form, Duration updateInterval) {
        super(updateInterval);
        __form = form;

        if (form != null) {
            form.setOutputMarkupId(true);
        }
    }

    @Override
    protected void onTimer(final AjaxRequestTarget target) {
        getForm().getRootForm().onFormSubmitted(new IFormSubmitter() {
            public Form<?> getForm() {
                return AjaxTimerFormSubmitBehavior.this.getForm();
            }

            public boolean getDefaultFormProcessing() {
                return AjaxTimerFormSubmitBehavior.this.getDefaultProcessing();
            }

            public void onSubmit() {
                AjaxTimerFormSubmitBehavior.this.onSubmit(target);
            }

            public void onError() {
                AjaxTimerFormSubmitBehavior.this.onError(target);
            }
        });
    }

    /**
     * @return Form that will be submitted by this behavior
     */
    public final Form<?> getForm() {
        if (__form == null) {
            __form = findForm();

            if (__form == null) {
                throw new IllegalStateException(
                        "form was not specified in the constructor and cannot "
                                + "be found in the hierarchy of the component this behavior "
                                + "is attached to: Component="
                                + getComponent().toString(false));
            }
        }
        return __form;
    }

    /**
     * @see Button#getDefaultFormProcessing()
     *
     * @return {@code true} for default processing
     */
    public boolean getDefaultProcessing() {
        return defaultProcessing;
    }

    /**
     * Finds form that will be submitted
     *
     * @return form to submit or {@code null} if none found
     */
    protected Form<?> findForm() {
        // try to find form in the hierarchy of owning component
        Component component = getComponent();
        if (component instanceof Form<?>) {
            return (Form<?>) component;
        } else {
            return component.findParent(Form.class);
        }
    }

    /**
     * Listener method that is invoked after the form has been submitted and
     * processed without errors
     *
     * @param target
     */
    protected abstract void onSubmit(AjaxRequestTarget target);

    /**
     * Listener method invoked when the form has been processed and errors
     * occurred
     *
     * @param target
     */
    protected abstract void onError(AjaxRequestTarget target);

}