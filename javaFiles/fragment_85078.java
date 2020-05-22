/**
 * Filter that can be used to exclude beans definitions from having their
 * {@link AbstractBeanDefinition#setLazyInit(boolean) lazy-init} set by the
 * {@link LazyInitializationBeanFactoryPostProcessor}.
 * <p>
 * Primarily intended to allow downstream projects to deal with edge-cases in which it is
 * not easy to support lazy-loading (such as in DSLs that dynamically create additional
 * beans). Adding an instance of this filter to the application context can be used for
 * these edge cases.
 * <p>
 * A typical example would be something like this:
 * <p>
 * <pre><code>
 * &#64;Bean
 * public static LazyInitializationExcludeFilter integrationLazyInitializationExcludeFilter() {
 *   return LazyInitializationExcludeFilter.forBeanTypes(IntegrationFlow.class);
 * }</code></pre>
 * <p>
 * NOTE: Beans of this type will be instantiated very early in the spring application
 * lifecycle so they should generally be declared static and not have any dependencies.
 *
 * @author Tyler Van Gorder
 * @author Philip Webb
 * @since 2.2.0
 */
@FunctionalInterface
public interface LazyInitializationExcludeFilter {