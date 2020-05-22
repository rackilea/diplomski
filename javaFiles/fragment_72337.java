public class SqlDateToLocalDateConverter
       implements Converter<LocalDate,java.sql.Date> {
    @Override
    public Result<java.sql.Date> convertToModel(LocalDate value,
           ValueContext context) {
        if (value == null) {
            return Result.ok(null);
        }
        return Result.ok( java.sql.Date.valueOf( value) );
    }
    @Override
    public LocalDate convertToPresentation(java.sql.Date value,
           ValueContext context) {
        return value.toLocalDate();
    }
}