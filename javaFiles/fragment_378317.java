public JSON addAttachment(File file) throws JiraException {
    try {
        return restclient.post(getRestUri(key) + "/attachments", file);
    } catch (Exception ex) {
        throw new JiraException("Failed add attachment to issue " + key, ex);
    }
}