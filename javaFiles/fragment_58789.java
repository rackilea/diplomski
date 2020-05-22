public class RestrictedTreeTableCell <S,T> extends TextFieldTreeTableCell<S, T>
{
  private final int maxChars;
  private final String pattern;
  private TextField textField = new TextField();
  private RestrictedTextField rtf ;
  private static final Logger log = Logger.getLogger(RestrictedTreeTableCell.class);

  public RestrictedTreeTableCell(int maxVal,String disallowed)
  {

      super();

      this.maxChars = maxVal;
      this.pattern = disallowed;
      if(pattern!=null || pattern.length()>0)
          rtf = new RestrictedTextField(textField, maxChars,pattern);
      else            
          rtf = new RestrictedTextField(textField, maxChars);

  }
  @Override public void startEdit() {

      log.debug("Inside over ridden edit");
      super.startEdit();
      if (isEditing()) {
          log.debug("Inside is editing  ");

         textField.textProperty().addListener(rtf);
         if(getItem()!=null)
          textField.setText(getItem().toString());
            setGraphic(textField);
            textField.selectAll();

      }
  }