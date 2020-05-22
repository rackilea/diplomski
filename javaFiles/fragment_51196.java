/**
 * Create a new {@link HttpMessageConverters} instance with the specified additional
 * converters.
 * @param additionalConverters additional converters to be added. New converters will
 * be added to the front of the list, overrides will replace existing items without
 * changing the order. The {@link #getConverters()} methods can be used for further
 * converter manipulation.
 */
public HttpMessageConverters(Collection<HttpMessageConverter<?>> additionalConverters) {
    List<HttpMessageConverter<?>> converters = new ArrayList<HttpMessageConverter<?>>();
    List<HttpMessageConverter<?>> defaultConverters = getDefaultConverters();
    for (HttpMessageConverter<?> converter : additionalConverters) {
        int defaultConverterIndex = indexOfItemClass(defaultConverters, converter);
        if (defaultConverterIndex == -1) {
            converters.add(converter);
        }
        else {
            defaultConverters.set(defaultConverterIndex, converter);
        }
    }
    converters.addAll(defaultConverters);
    this.converters = Collections.unmodifiableList(converters);
}