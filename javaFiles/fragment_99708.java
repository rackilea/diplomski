import android.text.util.Linkify;

// Recognize phone numbers and web URLs
Linkify.addLinks(text, Linkify.PHONE_NUMBERS | Linkify.WEB_URLS);

// Recognize all of the default link text patterns 
Linkify.addLinks(text, Linkify.ALL);