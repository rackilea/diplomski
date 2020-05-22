import play.i18n.MessagesApi;
import play.i18n.Messages;
import play.i18n.Lang;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

...

Locale englishLocale = new Locale("en");
Lang englishLang = new Lang(englishLocale);
List<Lang> prefferedLangs = Arrays.asList(englishLang);

Messages messagesCustom = messagesApi.preferred(prefferedLangs);

// the time for elegancy 
messages.at("ticket.form.title");