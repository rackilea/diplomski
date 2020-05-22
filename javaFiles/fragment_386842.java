public class ModalConfirmWindow extends WebPage {

    private Page parentPage;
    private ModalWindow modalConfirmWindow;    
    private int numberOfConflictingDays;

    public ModalConfirmWindow(Page parentPage, ModalWindow modalConfirmWindow, int numberOfConflictingDays) {
        this.parentPage = parentPage;
        this.modalConfirmWindow = modalConfirmWindow;        
        this.numberOfConflictingDays = numberOfConflictingDays;
        add(new ModalConfirmWindowForm("form"));
    }    

    private class ModalConfirmWindowForm extends Form {

        private static final long serialVersionUID = 10090L;

        public ModalConfirmWindowForm(String id) {
            super(id);

            add(new Label("value", " " + numberOfConflictingDays +" ").add(new SimpleAttributeModifier("style", "color: red")));
            add(new AjaxButton("cancelButton", this) {

                private static final long serialVersionUID = 10091L;

                @Override
                protected void onSubmit(AjaxRequestTarget target, Form form) {        
                    ((ParentPage)parentPage).setCancelButtonClicked(true);
                    modalConfirmWindow.close(target);
                }
            });
            add(new AjaxButton("okButton", this) {

                private static final long serialVersionUID = 10092L;

                @Override
                protected void onSubmit(AjaxRequestTarget target, Form form) {
                    ((ParentPage)parentPage).setCancelButtonClicked(false);
                    modalConfirmWindow.close(target);
                }
            });
        }

    }
}