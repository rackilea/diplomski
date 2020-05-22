public class MantissaFormat extends NumberFormat {  
@Override
/** Formats the value to a mantissa between [0,100] with two significant decimal places. */
public StringBuffer format(double value, StringBuffer buffer, FieldPosition field) {

String output;
String sign="";

if(!isFixed)
{
    if(value<0)
    {
      sign = "-";
      value = -value;
    }

    if(value!=0) {

        while(value<1) {            
          value *= 100;
        }  
        while(value>100){                   
         value/=100; 
        }    
    }
}
// value has the mantissa only. 
output = sign + String.format( "%.2f", value );    
buffer.append(output);
return buffer;
}

@Override
public Number parse(String string, ParsePosition position) {
// TODO Auto-generated method stub
throw new UnsupportedOperationException();    
}