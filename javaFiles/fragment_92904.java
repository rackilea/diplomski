public class JackRabbitServiceImpl {

        Repository repository = new TransientRepository(); 

        public JackRabbitServiceImpl() throws Exception{
            Session session = repository.login( 
                    new SimpleCredentials("username", "password".toCharArray()));
            try{
                InputStream stream = new BufferedInputStream(JackRabbitServiceImpl.class.getResourceAsStream("red_rose.jpg"));
                Node folder = session.getRootNode(); 
                Node file = folder.addNode("redrose.jpg","nt:file");
                Node content = file.addNode("jcr:content","nt:resource");
                Binary binary = session.getValueFactory().createBinary(stream);
                content.setProperty("jcr:data",binary);
                content.setProperty("jcr:mimeType","image/gif");
                session.save(); 
            }finally{
                session.logout(); 
            }
        }

        public byte[] getContentRose() throws Exception{
            Session session = repository.login( 
                    new SimpleCredentials("username", "password".toCharArray()));
            Node folder = session.getRootNode(); 
            Node file=folder.getNode("redrose.jpg");
            Node content=file.getNode("jcr:content");
            String path = content.getPath();
            Binary bin = session.getNode(path).getProperty("jcr:data").getBinary();
            InputStream stream = bin.getStream();
            return IOUtils.toByteArray(stream);
        }

    }