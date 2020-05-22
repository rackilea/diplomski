// define repetitive stuff in abstract class
public  abstract class TextConverterTag extends TagSupport{

    private  final long serialVersionUID = 1L;
    private String text;

    public String getText(){
        return text;
    }

    public void setText(final String text){
        this.text = text;
    }

    @Override
    public final int doStartTag() throws JspException{
        if(text != null){
            try{
                pageContext.getOut().append(process(text));
            } catch(final IOException e){
                throw new JspException(e);
            }
        }
        return TagSupport.SKIP_BODY;
    }

    protected abstract CharSequence process(String input);

}

// implementing class defines core functionality only
public  class UpperCaseConverter extends TextConverterTag{
    private  final long serialVersionUID = 1L;

    @Override
    protected CharSequence process(final String input){
        return input.toUpperCase();
    }
}

// implementing class defines core functionality only
public  class LowerCaseConverter extends TextConverterTag{
    private  final long serialVersionUID = 1L;

    @Override
    protected CharSequence process(final String input){
        return input.toLowerCase();
    }
}