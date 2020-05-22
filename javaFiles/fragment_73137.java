import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.DefaultDateTimeFormatInfo;
import com.google.gwt.i18n.client.LocaleInfo;
import com.google.gwt.i18n.client.impl.cldr.DateTimeFormatInfoImpl_de;
import com.google.gwt.i18n.client.impl.cldr.DateTimeFormatInfoImpl_en;
import com.google.gwt.i18n.client.impl.cldr.DateTimeFormatInfoImpl_es;
import com.google.gwt.i18n.client.impl.cldr.DateTimeFormatInfoImpl_fr;
import com.google.gwt.i18n.client.impl.cldr.DateTimeFormatInfoImpl_ru;
import com.google.gwt.i18n.client.impl.cldr.DateTimeFormatInfoImpl_zh;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.datepicker.client.DateBox;

public class GWTTestProject implements EntryPoint {

public static final native String getLanguage() /*-{
    return navigator.language;
}-*/;

public void onModuleLoad() {
    System.out.println(Arrays.toString(LocaleInfo.getAvailableLocaleNames()));

    loacleDate();
}

public void loacleDate() {
    Map<String, DefaultDateTimeFormatInfo> formats = new HashMap<String, DefaultDateTimeFormatInfo>();

    DefaultDateTimeFormatInfo formatDE = new DateTimeFormatInfoImpl_de();
    DefaultDateTimeFormatInfo formatEN = new DateTimeFormatInfoImpl_en();
    DefaultDateTimeFormatInfo formatFR = new DateTimeFormatInfoImpl_fr();
    DefaultDateTimeFormatInfo formatES = new DateTimeFormatInfoImpl_es();
    DefaultDateTimeFormatInfo formatZH = new DateTimeFormatInfoImpl_zh();
    DefaultDateTimeFormatInfo formatRU = new DateTimeFormatInfoImpl_ru();

    formats.put("de", formatDE);
    formats.put("en", formatEN);
    formats.put("fr", formatFR);
    formats.put("es", formatES);
    formats.put("zh", formatZH);
    formats.put("ru", formatRU);

    for (String key : formats.keySet()) {
        System.out.println(key + " - " + formats.get(key).dateFormat());
    }

    String language = getLanguage();

    DefaultDateTimeFormatInfo format = formats.get(language);
    DateTimeFormat dateFormat = null;
    if (format == null) {
        dateFormat = DateTimeFormat.getFormat(LocaleInfo.getCurrentLocale()
                .getDateTimeFormatInfo().dateFormatShort());
    } else {
        dateFormat = DateTimeFormat.getFormat(format.dateFormatFull());
    }

    System.out.println("Date formatted:" + dateFormat.format(new Date()));

    DateBox dateBox = new DateBox();
    dateBox.setFormat(new DateBox.DefaultFormat(dateFormat));
    RootPanel.get().add(dateBox);
}
}