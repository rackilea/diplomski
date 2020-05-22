public class CustomObjectMapper extends ObjectMapper {

    public SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

    public CustomObjectMapper() {
        super();
        super.setDateFormat(df);
    }