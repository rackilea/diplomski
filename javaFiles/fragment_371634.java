public class XmlRequest {

    @JacksonXmlElementWrapper(localName="REQUEST")
    private REQUEST request;


    public static class REQUEST {
        @JacksonXmlProperty(localName="ID")
        protected int ID;

        public int getID() {
            return ID;
        }

        public void setID(int iD) {
            ID = iD;
        }

    }

    public REQUEST getRequest() {
        return request;
    }

    public void setRequest(REQUEST request) {
        this.request = request;
    }
}