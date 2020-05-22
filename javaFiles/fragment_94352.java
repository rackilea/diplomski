public class SerializableCookie implements Serializable {

    private transient Cookie cookie;

    public SerializableCookie(Cookie cookie) {
        this.cookie = cookie;
    }

    public Cookie getCookie() {
        return cookie;
    }

    private void writeObject(ObjectOutputStream oos) throws IOException {
        oos.defaultWriteObject();
        oos.writeObject(cookie.getName());
        oos.writeObject(cookie.getPath());
        oos.writeObject(cookie.getDomain());
        // ...
    }

    private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException {
        ois.defaultReadObject();
        cookie = new Cookie();
        cookie.setName((String) ois.readObject());
        cookie.setPath((String) ois.readObject());
        cookie.setDomain((String) ois.readObject());
        // ...
    }

}