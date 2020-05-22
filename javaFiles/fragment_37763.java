public class LocalDateEditor extends PropertyEditorSupport{

 @Override
 public void setAsText(String text) throws IllegalArgumentException{
   setValue(Joda.getLocalDateFromddMMMyyyy(text));
 }

 @Override
 public String getAsText() throws IllegalArgumentException {
   return Joda.getStringFromLocalDate((LocalDate) getValue());
 }
}