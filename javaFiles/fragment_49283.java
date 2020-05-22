public class MathService implements MathServiceWS {
    @Resource
    private WebServiceContext context;

    @Override
    public Long add(AddBean add) {
        String payload = (String) context.getMessageContext().get(SOAP_MESSAGE_PAYLOAD);

        Long first = new Long(add.getFirst().intValue());
        Long second = new Long(add.getSecond().intValue());
        return Long.valueOf(Math.addExact(first.longValue(), second.longValue()));
    }
}