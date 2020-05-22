public class ResourcesLoader {

    private final static String Path = new File (".").getAbsolutePath () + File.separator + "resources";

    private List<ProxyRes>  resourcesList;

    public ResourcesLoader () throws Exception {
        resourcesList   = new ArrayList<ProxyRes> ();

        File resources  = new File (Path);
        for (String resName : resources.list ()) {
            File resFile    = new File (resources, resName);
            InputStream is  = new FileInputStream (resFile);
            JsonObject o    = new JsonObject (is);

            resourcesArr.add (o);
            resourcesList.add (buildObject (o));
        }
    }

    private ProxyRes buildObject (JsonObject o) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        ProxyRes r = new ProxyRes ();
        r.setPath (o.getString ("endpoint"));

        Class<?> clazz  = Class.forName (o.getString ("class"));
        CoapResource coapRes = (CoapResource)clazz.newInstance ();
        r.setCoapRes (coapRes);

        return r;
    }

    public List<ProxyRes> getResourcesList () {
        return resourcesList;
    }
}