import com.basho.riak.client.api.convert.ConversionException;
import com.basho.riak.client.api.convert.Converter;
import com.basho.riak.client.core.util.BinaryValue;
public class ChunkConverter extends Converter<Chunk> {

    public ChunkConverter() {
        super(Chunk.class);
    }

    public Chunk toDomain(BinaryValue val, String contentType) throws ConversionException {
        Chunk chunk = newDomainInstance();
        chunk.data = val.getValue();
    }

    public ContentAndType fromDomain(Chunk chunk) throws ConversionException {
        return new ContentAndType(BinaryValue.unsafeCreate(chunk.data), "application/octet-stream");
    }
}