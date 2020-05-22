String discountXML = "<discounts>";
    String discountTag = "<discount>"; // can be muliple
    discountTag += "<fixed>" + discountPrice + "</fixed>"; // REQUIRED
    discountTag += "<description>10% Discount Applied</description>";
    discountTag += "</discount>";
    discountXML += discountTag;
    discountXML += "</discounts>";

    BasketXmlFormatter xmlFormatter = new BasketXmlFormatter();
    String basketXml = xmlFormatter.toXml(iFormPayment, basket);
    basketXml = basketXml.replace("</basket>", discountXML + "</basket>");