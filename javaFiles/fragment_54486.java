public class AskTheUserController
{
    private DialogDisplayer dialogDisplayer;
    private MessageDisplayer messageDisplayer;

    public AskTheUserController(DialogDisplayer dialogDisplayer,
        MessageDisplayer messageDisplayer)
    {
        this.dialogDisplayer = dialogDisplayer;
        this.messageDisplayer = messageDisplayer;
    }

    public void AskTheUser()
    {
        if (this.dialogDisplayer.yesOrNo(
            "Do you like singletons?"
        )) {
            this.messageDisplayer.display("OK, thank you!");
        } else {
            this.messageDisplayer.display(
                "Visit http://singletons.apidesign.org to"
                + " change your mind!"
            );
        }
    }
}