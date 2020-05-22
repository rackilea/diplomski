public class ImapMessage {

    private String authority;
    private String protocol;
    private String host;
    private int port;
    private String username;
    private String password;
    private String foldername;
    private long msgid;
    private String filename;
    private Message message;

    public ImapMessage(String url) throws IOException, MessagingException {
        parseURL(decodeURL(url));
    }

    @Override
    public String toString() {
        return "protocol: "+protocol+"\n"+
               "host: "+host+"\n"+
               "port: "+port+"\n"+
               "username: "+username+"\n"+
               "password: "+password+"\n"+
               "folder: "+foldername+"\n"+
               "msgid: "+msgid+"\n"+
               "filename: "+filename;
    }

    private String decodeURL(String url) throws IOException {
        if(url!=null && !url.isEmpty()) {
            String newurl = "";
            for(int i=0; i<url.length(); i+=2) {
                newurl+=url.substring(i, i+1);
            }
            newurl = StringUtils.replace(newurl, "%3E", ">");
            newurl = StringUtils.replace(newurl, "%20", " ");
            return newurl;
        } else {
            throw new IOException("The given URL is empty or invalid.");
        }
    }


    private void parseURL(String url) throws IOException, MalformedURLException {
        if(url!=null && !url.isEmpty()) {
            //<editor-fold defaultstate="collapsed" desc="Parse Protocol">
            if(url.startsWith("imaps")) {
                url = StringUtils.replace(url, "imaps", "http", 1);
                protocol = "imaps";
            } else if(url.startsWith("imap")) {
                url = StringUtils.replace(url, "imap", "http", 1);
                protocol = "imap";
            } else {
                throw new IOException("Unsupported protocol: "+url.substring(0, url.indexOf("://")));
            }

            try {
                URL newurl = new URL(url);
                String path = newurl.getPath();
                String query = newurl.getQuery();
                authority = newurl.getAuthority();
                host = newurl.getHost();
                port = newurl.getPort();
                username = newurl.getUserInfo();
                password = "provide your password here";
                foldername = path.substring(path.indexOf(">/")+2, path.lastIndexOf(">"));
                msgid = Long.parseLong(path.substring(path.lastIndexOf(">")+1, path.length()));
                filename = query.substring(query.indexOf("=")+1, query.length());
            } catch (MalformedURLException ex) {
                throw ex;
            }
        } else {
            throw new IOException("The given URL is empty or invalid.");
        }
    }

        public File fetchMessage() throws IOException, FileNotFoundException, MessagingException {

            Store store = null;
            Folder folder = null;
            File filepath = new File("/destination/directory");
            try {
                Properties props = System.getProperties();
                props.setProperty("mail.store.protocol", protocol);
                Session session = Session.getDefaultInstance(props, null);
                // session.setDebug(true);
                store = session.getStore(protocol);
                store.connect(host, port, username, password);
                folder = store.getFolder(foldername);
                folder.open(Folder.READ_ONLY);
                UIDFolder ufolder = (UIDFolder)folder;
                message = ufolder.getMessageByUID(msgid);
                if(message!=null) {
                    File file = null;
                    if(filename.equals("null")) {
                        file = new File(filepath.getAbsolutePath()+File.separator+Long.toString(System.nanoTime())+".eml");
                    } else {
                        file = new File(filepath.getAbsolutePath()+File.separator+filename);
                    }
                    message.writeTo(new FileOutputStream(file));
                    return file;
                } else {
                    throw new MessagingException("The requested e-mail could not be found on the mail server.");
                }
            } catch(Exception ex) {
                throw ex;
            } finally {
                if(folder!=null) {
                    folder.close(true);
                }
                if(store!=null) {
                    store.close();
                }
            }
        }

    }