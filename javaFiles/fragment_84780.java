String uriString = request.getRequestLine().getUri();
    Uri uri = Uri.parse(uriString);
    if (uri != null) {
        if (uri.toString().contains("mypic.jpg")) {
            HttpEntity entity = new EntityTemplate(new ContentProducer() {
                public void writeTo(final OutputStream outstream)
                        throws IOException {
                    InputStream is = context.getResources()
                            .openRawResource(R.raw.mypic);
                    copyStream(is, outstream);
                }
            });
            response.setHeader("Content-Type", "image/jpg");
            response.setEntity(entity);
        }
        else{
            HttpEntity entity = new EntityTemplate(new ContentProducer() {
                public void writeTo(final OutputStream outstream)
                        throws IOException {
                    InputStream is = context.getResources().openRawResource(
                            R.raw.home);
                    copyStream(is, outstream);
                }
            });
            response.setHeader("Content-Type", "text/html");
            response.setEntity(entity);
        }
    }