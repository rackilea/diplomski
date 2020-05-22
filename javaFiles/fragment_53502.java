if (transformTemplateRequest == null) {
    synchronized (lockObj) {
        if (transformTemplateRequest == null) {
            TransformerFactory tf = TransformerFactory.newInstance();
            Source xsltSource = new DOMSource(xslt);
            transformTemplateRequest = tf.newTemplates(xsltSource);
        }
    }
}