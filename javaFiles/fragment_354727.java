public class ProxyRes {

    public  CoapResource coapRes;
    public  String  path;

    public ProxyRes () {
    }

    public CoapResource getCoapRes () {
        return coapRes;
    }

    public void setCoapRes (CoapResource coapRes) {
        this.coapRes = coapRes;
    }

    public String getPath () {
        return path;
    }

    public void setPath (String path) {
        this.path = path;
    }
}