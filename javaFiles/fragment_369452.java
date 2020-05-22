// This is for the alias
@SuppressWarnings({ "unchecked", "rawtypes" })
     Alias getAlias(SdtPr element) {

        for (Object o : element.getRPrOrAliasOrLock()) {
            if (o instanceof JAXBElement  && ((JAXBElement)o).getValue() instanceof Alias) {
                return ((JAXBElement<Alias>)o).getValue();
            }
        }
        return null;
    }

    // this is for the tag
     Tag getTag(SdtPr element) {

        for (Object o : element.getRPrOrAliasOrLock()) {
            if (o instanceof Tag) {
                return (Tag) o;
            }
        }
        return null;
    }