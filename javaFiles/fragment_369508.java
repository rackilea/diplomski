import com.ibm.icu.text.RuleBasedNumberFormat;
import com.ibm.icu.text.SimpleDateFormat;

...

SimpleDateFormat sdf = 
    new SimpleDateFormat("EEEE, MMMM d", Locale.ENGLISH);

sdf.setNumberFormat(
    new RuleBasedNumberFormat(
        Locale.ENGLISH, RuleBasedNumberFormat.ORDINAL));

System.out.println(sdf.format(new Date()));