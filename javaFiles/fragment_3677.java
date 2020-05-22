public class ZoneTrimTransformer implements ZoneTransformer {

private int maxLength;

public ZoneTrimTransformer(int maxLength) {
    this.maxLength = maxLength;
}

@Override
public Object transform(Object value) {
    if (value == null) {
        return null;
    }
    else {
        String val = value.toString();
        if (getDBRequireLength(val) > getJavaLength(val) ){
            return transformOverhead(val);
        }
        else if (val != null && getJavaLength(val) > maxLength) {

            // Trim
            val = val.substring(0, maxLength);
        }

        return val;
    }
}

public static void main(String[] args) {
    System.out.println("1234567".substring(0, 5));
}

public  int getJavaLength(String val) {
    return val.length();
}

public  int getDBRequireLength(String val) {
    return val.getBytes().length;
}

private  Object transformOverhead(Object s) {
    byte[] byeArray = s.toString().getBytes();
    if (byeArray.length < maxLength) maxLength = byeArray.length;
    int n16 = 0;
    int advance = 1;
    int i = 0;
    while (i < maxLength) {
        advance = 1;
        if ((byeArray[i] & 0x80) == 0) i += 1;
        else if ((byeArray[i] & 0xE0) == 0xC0) i += 2;
        else if ((byeArray[i] & 0xF0) == 0xE0) i += 3;
        else { i += 4; advance = 2; }
        if (i <= maxLength) n16 += advance;
    }
    return s.toString().substring(0,n16);
    }
}