import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Locale;

import com.bbtransact.tss.api.commons.http.HttpConstants;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

public class SmartLocaleResolver extends AcceptHeaderLocaleResolver {
  @Override
  public Locale resolveLocale(HttpServletRequest request) {
     if (StringUtils.isBlank(request.getHeader("Accept-Language"))) {
         return Locale.getDefault();
       }
     List<Locale.LanguageRange> list = Locale.LanguageRange.parse(request.getHeader("Accept-Language"));
     Locale locale = Locale.lookup(list, ApplicationConstants.LOCALES);
      return locale;
     }
}