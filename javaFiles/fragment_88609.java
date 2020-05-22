String token = (String) session.getAttribute(Globals.TRANSACTION_TOKEN_KEY);
if (token != null) {
  results.append("<input type=\"hidden\" name=\"");
  results.append(Constants.TOKEN_KEY);
  results.append("\" value=\"");
  results.append(token);
  if (this.isXhtml()) {
      results.append("\" />");
  } else {
     results.append("\">");
  }
}