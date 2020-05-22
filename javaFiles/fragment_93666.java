public class KeepItSimpleStupidAction extends ActionSupport {

    @Inject Logger LOG;

    private String text; // text is always encrypted inside the action

    public String getText() { // but it can also be read decrypted by calling the getter 
        return ASEEncDecUtil.decrypt(text.getBytes("UTF-8"));
    }

    public void setText(String text) { // the setter automatically encrypts it
        this.text = ASEEncDecUtil.encrypt(text.getBytes("UTF-8"));
    }

    public String execute() {
        LOG.debug("text decrypted: " + getText());
        LOG.debug("text encrypted: " + text);
        return SUCCESS;
    }

}