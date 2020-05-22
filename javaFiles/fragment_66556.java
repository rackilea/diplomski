/**
 * Add a subflow as an alternative to a {@link #channelMapping(Object, String)}.
 * {@link #prefix(String)} and {@link #suffix(String)} cannot be used when subflow
 * mappings are used.
 * <p> If subflow should refer to the external {@link IntegrationFlow} bean and
 * there is a requirement to expect reply from there, such a reference should be
 * wrapped with a {@code .gateway()}:
 * <pre class="code">
 * {@code
 *     .subFlowMapping(false, sf -> sf.gateway(evenFlow())))
 * }
 * </pre>
 * @param key the key.
 * @param subFlow the subFlow.
 * @return the router spec.
 */
public RouterSpec<K, R> subFlowMapping(K key, IntegrationFlow subFlow) {