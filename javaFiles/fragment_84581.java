public class XYZServiceImpl {
    public XYZServiceImpl(XYZMapperFactory mapperFactory) {
        this.mapperFactory = mapperFactory;
    }

    public XYZMapper getXYZMapper() {
        return mapperFactory.getMapper();
    }
}