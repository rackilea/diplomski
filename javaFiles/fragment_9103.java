public class AppDataFormConverter implements Converter<String, ComponentDataForm>{

@Override
public ComponentDataForm convert(String s) {
    System.out.println(s);
    ObjectMapper objectMapper = new ObjectMapper();
    try {
          return objectMapper.readValue(s, ComponentDataForm.class);
        } catch (IOException ex) {
        Logger.getLogger(AppDataFormConverter.class.getName()).log(Level.SEVERE, null, ex);
        }
    System.out.println("handled here");
    return new ComponentDataForm();
    }

}