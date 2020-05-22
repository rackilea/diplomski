@Override
public boolean deSerialize(T message, byte[] value) 
{
    // protocol messages return boolean whether parsing succeeded
    return message.newBuilderForType().mergeFrom(value).build();
}