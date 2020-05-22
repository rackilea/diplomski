public void startElement(String uri, String localName, String elementName, Attributes attributes) throws SAXException {

    if (elementName.equalsIgnoreCase(GenericConstants.INFO)) {
        this.searchRaidusBean.setServer(attributes.getValue(GenericConstants.SERVER));
        this.searchRaidusBean.setFunction(attributes.getValue(GenericConstants.FUNCTION));
    }
    if (elementName.equalsIgnoreCase(GenericConstants.RESULT)) {
        this.searchRaidusBean.setResultCode(attributes.getValue(GenericConstants.CODE));
    }

    if (elementName.equalsIgnoreCase(GenericConstants.ACCOUNT)) {
        this.searchRaidusBean.setLoginId(attributes.getValue(GenericConstants.LOGIN));
        this.searchRaidusBean.setSkyNum(attributes.getValue(GenericConstants.SKYNUM));
        this.searchRaidusBean.setMaxAliases(attributes.getValue(GenericConstants.MAXALIASES));
        this.searchRaidusBean.setCreationDate(attributes.getValue(GenericConstants.CREATION_DATE));
        this.searchRaidusBean.setType(attributes.getValue(GenericConstants.TYPE));
        this.searchRaidusBean.setStatus(attributes.getValue(GenericConstants.STATUS));
        this.searchRaidusBean.setMnemonic(attributes.getValue(GenericConstants.MNEMONIC));
        this.searchRaidusBean.setRateLimit(attributes.getValue(GenericConstants.RATELIMIT));
    }

    if (elementName.equalsIgnoreCase(GenericConstants.SETTINGS)) {

        for (int index = 0; index < attributes.getLength(); index++) {

            String attName = attributes.getLocalName(index);
            String value = attributes.getValue(index);

            map.put(attName, value);

        }

    }

    if (elementName.equalsIgnoreCase(GenericConstants.ALIASES)) {
        this.tempKey = attributes.getValue(GenericConstants.MNEMONIC);
    }

}