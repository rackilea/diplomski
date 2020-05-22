XStream xstream = new XStream();
    xstream.registerConverter(new FlightsConverter());
    xstream.alias("airport", AirportPojo.class);
    xstream.alias("flights", FlightsPojo.class);
    xstream.alias("flight", FlightPojo.class);
    xstream.useAttributeFor(AirportPojo.class, "flights");
    AirportPojo airportPojo = (AirportPojo) xstream.fromXML(xml);