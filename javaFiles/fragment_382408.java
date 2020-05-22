class FlightsConverter implements Converter {
    @Override
    public boolean canConvert(Class clazz) {
        return clazz.equals(FlightsPojo.class);
    }

    @Override
    public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
        FlightsPojo flightsPojo = new FlightsPojo();
        flightsPojo.setFlights(new ArrayList<FlightPojo>());
        while (reader.hasMoreChildren()) {
            reader.moveDown();
            FlightPojo flightPojo = (FlightPojo) context.convertAnother(flightsPojo, FlightPojo.class);
            flightsPojo.getFlights().add(flightPojo);
            System.out.println(reader.getValue());
            reader.moveUp();
        }
        return flightsPojo;
    }

    @Override
    public void marshal(Object value, HierarchicalStreamWriter writer, MarshallingContext context) {
        // todo...
    }
}