import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.convert.ConversionFailedException;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.ConditionalGenericConverter;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Base64;
import java.util.Collections;
import java.util.Set;

@Component
public class Base64JsonToObjectConverter implements ConditionalGenericConverter {

    private final ObjectMapper objectMapper;
    private final Base64.Decoder decoder;

    public Base64JsonToObjectConverter() {
        this.objectMapper = new ObjectMapper();
        this.decoder = Base64.getDecoder();
    }

    @Override
    public boolean matches(TypeDescriptor sourceType, TypeDescriptor targetType) {
        return targetType.hasAnnotation(Base64Encoded.class);
    }

    @Override
    public Set<ConvertiblePair> getConvertibleTypes() {
        return Collections.singleton(new ConvertiblePair(String.class, Object.class));
    }

    @Override
    public Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {
        if (source == null) {
            return null;
        }
        String string = (String) source;

        try {
            byte[] decodedValue = this.decoder.decode(string);

            return this.objectMapper.readValue(decodedValue, targetType.getType());
        } catch (IllegalArgumentException | IOException e) {
            throw new ConversionFailedException(sourceType, targetType, source, e);
        }
    }
}