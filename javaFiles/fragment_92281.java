public class OkCancelDialog extends Dialog {
    private String text=null, okText=null, cancelText=null;

    public OkCancelDialog (String text, String okText, String cancelText){
        super ();
        this.text = text;
        this.okText = okText;
        this.cancelText = cancelText;
    }

    public void setText (String text) { this.text = text; }
    public void setOkText (String okText) { this.okText = okText; }
    public void setCancelText (String cancelText) {this.cancelText = cancelText; } 

    public boolean show () { 
        return super.show (this.title, this.text, this.okText, this.cancelText); 
    }       
}