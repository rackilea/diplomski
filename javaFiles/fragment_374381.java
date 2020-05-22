public class Main {
    public static void main(String... ignored) throws Exception {
        SimpleBean sb = new SimpleBean();

        BeanInfo info = Introspector.getBeanInfo(SimpleBean.class);
        System.out.println("Calling setters");
        for (PropertyDescriptor pd : info.getPropertyDescriptors()) {
            if (pd.getWriteMethod() == null) continue;
            System.out.println("\tSetting " + pd.getName());
            pd.getWriteMethod().invoke(sb, "Set now");
        }
        System.out.println("Reading the getters");
        for (PropertyDescriptor pd : info.getPropertyDescriptors()) {
            System.out.println("\t" + pd.getName() + " = " + pd.getReadMethod().invoke(sb));
        }
    }


    public static class SimpleBean {
        String text;
        String words;

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getWords() {
            return words;
        }

        public void setWords(String words) {
            this.words = words;
        }
    }
}