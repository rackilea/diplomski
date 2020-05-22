public class TAnimal implements ORAData, ORADataFactory {
    Integer animal_id, number_of_hairs;

    public TAnimal() { }

    // [ Getter and Setter omitted here ]

    @Override
    public Datum toDatum(Connection connection) throws SQLException {
        OracleConnection oracleConnection = connection.unwrap(OracleConnection.class);
        StructDescriptor structDescriptor = StructDescriptor.createDescriptor("zoo_schema.T_ANIMAL", oracleConnection);
        Object[] attributes = {
                this.animal_id,
                this.number_of_hairs
        };
        return new STRUCT(structDescriptor, oracleConnection, attributes);
    }

    @Override
    public TAnimal create(Datum datum, int sqlTypeCode) throws SQLException {
        if (datum == null) {
            return null;
        }
        Datum[] attributes = ((STRUCT) datum).getOracleAttributes();
        TAnimal result = new TAnimal();
        result.animal_id = asInteger(attributes[0]); // see TEnclosure#asInteger(Datum)
        result.number_of_hairs = asInteger(attributes[1]); // see TEnclosure#asInteger(Datum)
        return result;
    }

}