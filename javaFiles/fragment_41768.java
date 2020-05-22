package com.pnt.common.propertyeditor;

import java.beans.PropertyEditorSupport;
import com.pnt.util.number.NumUtils;

public class IntegerPropertyEditor extends PropertyEditorSupport {



//private static final Log logger = LogFactory.getLog(IntegerPropertyEditor.class);





public void setValue(Object value) {

    if (value==null) {
        super.setValue(null);
    } 

    else if (value instanceof Integer) {
        super.setValue(value);
    }

    else if (value instanceof String) {
        setValue(NumUtils.stringToInteger((String)value));
    }

    else {
        super.setValue(NumUtils.stringToInteger(value.toString()));
    }       
}


public void setAsText(String text) {
    setValue(NumUtils.stringToInteger(text.replaceAll(" ", "")));
}


public String getAsText() {
    Integer value = (Integer)getValue();
    if (value != null){ 
        String t = value.toString();
        int k = 1;
        for (int i = t.length() - 1; i >= 0; i--) {
            if (k % 3 == 0 && i != 0)
                t = t.substring(0, i) + " " + t.substring(i);
            k++;
        }
        return t;

    } 
    else 
        return "";
}
}