private InputStream getFormBody(HttpServletRequest request) throws IOException {
    ByteArrayOutputStream bos = new ByteArrayOutputStream();
    Writer writer = new OutputStreamWriter(bos, FORM_CHARSET);

    Map<String, String[]> form = request.getParameterMap();
    for (Iterator<String> nameIterator = form.keySet().iterator(); nameIterator.hasNext();) {
        String name = nameIterator.next();
        List<String> values = Arrays.asList(form.get(name));
        for (Iterator<String> valueIterator = values.iterator(); valueIterator.hasNext();) {
            String value = valueIterator.next();
            writer.write(URLEncoder.encode(name, FORM_CHARSET));
            if (value != null) {
                writer.write('=');
                writer.write(URLEncoder.encode(value, FORM_CHARSET));
                if (valueIterator.hasNext()) {
                    writer.write('&');
                }
            }
        }
        if (nameIterator.hasNext()) {
            writer.append('&');
        }
    }
    writer.flush();

    return new ByteArrayInputStream(bos.toByteArray());
}