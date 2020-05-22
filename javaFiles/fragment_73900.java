ErnstReuterPlatzBuildings() {
    try {
        this.buildingsByIds = composeBuildingsByIds(
            getBuildings(ErnstReuterPlatzBuildings.class)
        );
    } catch (ParserConfigurationException pce) {
        throw new ExceptionInInitializerError(pce);
    } catch (SAXException sxe) {
        throw new ExceptionInInitializerError(sxe);
    } catch (XPathExpressionException xpe) {
        throw new ExceptionInInitializerError(xpe);
    } catch (IOException ioe) {
        throw new ExceptionInInitializerError(ioe);
    } 
}