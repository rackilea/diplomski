public class TEnclosure implements ORAData, ORADataFactory {

    Integer enclosureId;
    String enclosureName;
    List<Animal> animals;

    public TEnclosure() {
        this.animals = new ArrayList<>();
    }

    // [ Getter and Setter omitted here ]

    @Override
    public Datum toDatum(Connection connection) throws SQLException {
        OracleConnection oracleConnection = connection.unwrap(OracleConnection.class);
        StructDescriptor structDescriptor = StructDescriptor.createDescriptor("zoo_schema.T_ENCLOSURE", oracleConnection);
        Object[] attributes = {
                this.enclosureId,
                this.enclosureName,
                null // TODO: solve this; however, retrieving data works without this
        };
        return new STRUCT(structDescriptor, oracleConnection, attributes);
    }

    @Override
    public TEnclosure create(Datum datum, int sqlTypeCode) throws SQLException {
        if (datum == null) {
            return null;
        }
        Datum[] attributes = ((STRUCT) datum).getOracleAttributes();
        TEnclosure result = new TEnclosure();
        result.enclosureId = asInteger(attributes[0]);
        result.enclosureName = asString(attributes[1]);
        result.animals = asListOfAnimals(attributes[2]);
        return result;
    }

    // Utility methods

    Integer asInteger(Datum datum) throws SQLException {
        if (datum == null)
            return null;
        else
            return ((NUMBER) datum).intValue(); // oracle.sql.NUMBER
    }

    String asString(Datum datum) throws SQLException {
        if (datum = null)
            return null;
        else
            return ((CHAR) datum).getString(); // oracle.sql.CHAR
    }

    List<TAnimal> asListOfAnimals(Datum datum) throws SQLException {
        if (datum == null)
            return null;
        else {
            TAnimal factory = new TAnimal();

            List<TAnimal> result = new ArrayList<>();

            ARRAY array = (ARRAY) datum; // oracle.sql.ARRAY
            Datum[] elements = array.getOracleArray();
            for (int i = 0; i < elements.length; i++) {
                result.add(factory.create(elements[i], 0));
            }
            return result;
        }
    }
}