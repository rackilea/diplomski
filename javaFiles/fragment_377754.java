@Component
class FileContentMD5Expression implements Expression {
    @Override
    public <T> T evaluate(Exchange exchange, Class<T> type) {
        if (type != String.class){
            throw new IllegalArgumentException("This is String only expression");
        }
        try (FileInputStream fis = new FileInputStream(((File)exchange.getIn(GenericFileMessage.class).getGenericFile().getFile()))) {
            return type.cast(DigestUtils.md5Hex(fis));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}