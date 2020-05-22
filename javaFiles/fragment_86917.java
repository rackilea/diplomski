public class DutyBlockCodecProvider implements CodecProvider {
    @Override
    public <T> Codec<T> get(Class<T> type, CodecRegistry cr) {
        if (type == DutyBlock.class) {
            return (Codec<T>) new DutyBlockCodec(cr);
        }
        return null;
    }
}