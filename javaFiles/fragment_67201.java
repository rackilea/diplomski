import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.text.MaskFormatter;
import java.awt.FlowLayout;
import java.text.AttributedCharacterIterator;
import java.text.FieldPosition;
import java.text.Format;
import java.text.NumberFormat;
import java.text.ParsePosition;

public class FormattedTextFieldDemo {
  public static void main(String[] args) {
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(100, 75);
    JPanel content = new JPanel(new FlowLayout());
    frame.setContentPane(content);

    JFormattedTextField f1 = new JFormattedTextField(createFormat());
    f1.setValue(null);
    f1.setColumns(1);

    JFormattedTextField f2 = new JFormattedTextField(createFormat());
    f2.setValue(null);
    f2.setColumns(1);

    content.add(f1);
    content.add(f2);

    JFormattedTextField f3 = new JFormattedTextField(createFormatter());
    f3.setValue(null);
    f3.setColumns( 1 );

    JFormattedTextField f4 = new JFormattedTextField(createFormatter());
    f4.setValue(null);
    f4.setColumns(1);

    content.add(f3);
    content.add(f4);

    frame.setVisible(true);
  }

  private static MaskFormatter createFormatter() {
    MaskFormatter formatter = null;
    try {
      formatter = new MaskFormatter("#");
      formatter.setValidCharacters("123456789");
    } catch (java.text.ParseException exc) {
      System.err.println("formatter is bad: " + exc.getMessage());
      System.exit(-1);
    }
    return (formatter);
  }

  private static Format createFormat(){
    final NumberFormat format = NumberFormat.getInstance();
    format.setParseIntegerOnly( true );
    return new Format() {
      @Override
      public StringBuffer format( Object obj, StringBuffer toAppendTo, FieldPosition pos ) {
        return format.format( obj, toAppendTo, pos );
      }

      @Override
      public AttributedCharacterIterator formatToCharacterIterator( Object obj ) {
        return format.formatToCharacterIterator( obj );
      }


      @Override
      public Object parseObject( String source, ParsePosition pos ) {
        int initialIndex = pos.getIndex();
        Object result = format.parseObject( source, pos );
        if ( result != null && pos.getIndex() > initialIndex + 1 ) {
          int errorIndex = initialIndex + 1;
          pos.setIndex( initialIndex );
          pos.setErrorIndex( errorIndex );
          return null;
        }
        return result;
      }
    };
  }
}