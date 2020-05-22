import java.net.URLEncoder;

// ... 

  URL url = new URL(
    completeURL + "/contacts?select=lastname&"
    + URLEncoder.encode("$filter", "UTF-8") + "="
    + URLEncoder.encode("telephone1 eq '"+phoneNumber+"'", "UTF-8"));