public class FeedbackTextField<T> extends FormComponent<T> {

    public FeedbackTextField(String id) {
         this(id, null);
    }

    public FeedbackTextField(String id, IModel<T> model) {
         super(id, model);

         TextField<T> tf = new TextField<T>("tx");
         add(tf);
         add(new FeedbackPanel("fb").setFilter(new ComponentFeedbackMessageFilter(tf))); 
    }
}