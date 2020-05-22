import com.fasterxml.jackson.databind.ObjectMapper;
private static Form<Computer> editableForm(final Computer obj) {
            ObjectMapper mapper = new ObjectMapper();
            Form<Computer> form = Form.form(Computer.class);
            Map<String,String> data = mapper.convertValue(obj, Map.class);
            Map<String, String> submittedData = form.bindFromRequest().data();
            data.putAll(submittedData);
            return form.bind(data);
        }