@Override
@SuppressWarnings({ "unchecked", "rawtypes" })
public T extractData(ClientHttpResponse response) throws IOException {
    if (!hasMessageBody(response)) {
        return null;
    }
    MediaType contentType = getContentType(response);

    for (HttpMessageConverter<?> messageConverter : this.messageConverters) {
        if (messageConverter instanceof GenericHttpMessageConverter) {
            GenericHttpMessageConverter<?> genericMessageConverter = (GenericHttpMessageConverter<?>) messageConverter;
            if (genericMessageConverter.canRead(this.responseType, null, contentType)) {
                if (logger.isDebugEnabled()) {
                    logger.debug("Reading [" + this.responseType + "] as \"" +
                            contentType + "\" using [" + messageConverter + "]");
                }
                return (T) genericMessageConverter.read(this.responseType, null, response);
            }
        }
        if (this.responseClass != null) {
            if (messageConverter.canRead(this.responseClass, contentType)) {
                if (logger.isDebugEnabled()) {
                    logger.debug("Reading [" + this.responseClass.getName() + "] as \"" +
                            contentType + "\" using [" + messageConverter + "]");
                }
                return (T) messageConverter.read((Class) this.responseClass, response);
            }
        }
    }
    throw new RestClientException(
            "Could not extract response: no suitable HttpMessageConverter found for response type [" +
                    this.responseType + "] and content type [" + contentType + "]");
}