public class KTagLib extends AbstractTagLibrary {
    public static final String NAMESPACE = "http://mysite.blah/tags";
    public static final KTagLib INSTANCE = new KTagLib();

    public KTagLib() {
        super(NAMESPACE);
        try{
            try {
                Method[] methods = KTags.class.getMethods();

                for (int i = 0; i < methods.length; i++) {
                    if (Modifier.isStatic(methods[i].getModifiers())) {
                        this.addFunction(methods[i].getName(), methods[i]);
                    }
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }            
        }
    }