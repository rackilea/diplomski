InputSource inputSource = new InputSource(context.getResources().openRawResource(R.raw.schedule_default));
XPath xPath = XPathFactory.newInstance().newXPath();
String image;       

try {
    image = xPath.evaluate("//stage[@token=3]/image/text()", inputSource);
} catch (XPathExpressionException e) {
    Log.e(LOG_TAG, "Error evaluating xpath expression.");
    e.printStackTrace();
    return null;
}