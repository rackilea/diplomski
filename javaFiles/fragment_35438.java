for (int i = 0; i < temps.getLength(); i++)
{
    Element currentConditionsElement = (Element) temps.item(i);
    NodeList conditionList = currentConditionsElement.getElementsByTagName("condition");
    Element conditionElement = (Element) conditionList.item(0);
    String dataAttribute = conditionElement.getAttribute("data");
}