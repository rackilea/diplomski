public class CTOValueFormatter extends AbstractValueFormatter<String, String>{
        @Override
        public String format(String value, ReportParameters reportParameters) {
           return value.split("-")[1];
        }
    }

    public class CTOrderExpression extends AbstractComplexExpression<String> {

        public CTOrderExpression(String sortField, String showField) {
            addExpression(field(sortField, Integer.class));
            addExpression(field(showField, String.class));
        }

        @Override
        public String evaluate(List<?> list, ReportParameters rp) {
            return list.get(0) + "-" + list.get(1);
        }
    }