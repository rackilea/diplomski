PostMethod post = new PostMethod(server.getUrl());
    post.setParameter("XMLString", query);
    post.setRequestContentLength(PostMethod.CONTENT_LENGTH_AUTO);
    post.setStrictMode(true);
    try {
        client.executeMethod(post);
        return post.getResponseBodyAsString();
    } finally {
        post.releaseConnection();
    }