import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.fasterxml.jackson.databind.ser.BeanSerializerModifier;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.List;

public class JsonApp {

    public static void main(String[] args) throws Exception {
        SimpleModule unitModule = new SimpleModule();
        unitModule.setSerializerModifier(new UnitBeanSerializerModifier());

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(unitModule);

        Pojo pojo = new Pojo();
        System.out.println(mapper.writeValueAsString(pojo));
    }
}