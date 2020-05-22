public class MyFormatNumberTag extends FormatNumberTag {

   public MyFormatNumberTag() {
       super();
   }

   //...snip...

   @Override
   public int doStartTag() throws JspException {
       Locale locale = getMyRequestLocale();

       if(locale == Locale.EN_GB) setCurrencySymbol("");

       return super.doStartTag();
   }
}