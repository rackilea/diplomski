public class PsqlArrayDataTypeFactory extends DefaultDataTypeFactory {
        public DataType createDataType(int sqlType, String sqlTypeName) throws DataTypeException {
            if (sqlType == Types.ARRAY)
            {
                return DataType.VARCHAR;
            }

            return super.createDataType(sqlType, sqlTypeName);
        }
    }