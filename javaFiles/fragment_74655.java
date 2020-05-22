public class My_table
    extends Table
{
    @Override
    protected String formatPropertyValue(final Object      a_row_id,
                                         final Object      a_col_id,
                                         final Property<?> a_property)

    {
        if (a_property.getType() == BigDecimal.class
            && null != a_property.getValue())
        {
            return "formatted-value";
        }

        return super.formatPropertyValue(a_row_id, a_col_id, a_property);
    }
}