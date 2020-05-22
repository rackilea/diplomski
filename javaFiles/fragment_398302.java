import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.fasterxml.jackson.databind.ser.BeanSerializerModifier;

import java.util.List;
import java.util.stream.Collectors;

public class JsonApp {

    public static void main(String[] args) throws Exception {
        SimpleModule module = new SimpleModule();
        module.setSerializerModifier(new BeanSerializerModifier() {
            @Override
            public List<BeanPropertyWriter> changeProperties(SerializationConfig config, BeanDescription beanDesc, List<BeanPropertyWriter> beanProperties) {
                if (beanDesc.getBeanClass() == Response.class) {
                    return beanProperties.stream()
                            .map(SilentExceptionBeanPropertyWriter::new)
                            .collect(Collectors.toList());

                }

                return super.changeProperties(config, beanDesc, beanProperties);
            }
        });

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(module);


        System.out.println(mapper.writeValueAsString(new Response(1, "ONE")));
        System.out.println(mapper.writeValueAsString(new Response(-1, "MINUS")));
        System.out.println(mapper.writeValueAsString(new Response(-1, null)));
    }
}

class SilentExceptionBeanPropertyWriter extends BeanPropertyWriter {

    public SilentExceptionBeanPropertyWriter(BeanPropertyWriter base) {
        super(base);
    }

    @Override
    public void serializeAsField(Object bean, JsonGenerator gen, SerializerProvider prov) throws Exception {
        try {
            super.serializeAsField(bean, gen, prov);
        } catch (Exception e) {
            Throwable cause = e.getCause();
            gen.writeFieldName(_name);
            gen.writeString(cause.getClass().getName() + ":" + cause.getMessage());
        }
    }
}


class Response {

    private int count;
    private String message;

    public Response(int count, String message) {
        this.count = count;
        this.message = message;
    }

    public int getCount() {
        if (count < 0) {
            throw new IllegalStateException("Count is less than ZERO!");
        }
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getMessage() {
        if (message == null) {
            throw new NullPointerException("message can not be null!");
        }
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}