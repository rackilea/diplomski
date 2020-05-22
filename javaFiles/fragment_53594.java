import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import org.glassfish.hk2.api.Factory;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.process.internal.RequestScoped;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Stack Overflow question https://stackoverflow.com/q/36871274/2587435
 * 
 * Run this like any other JUnit test. Only one required test dependency:
 * 
 *  <dependency>
 *      <groupId>org.glassfish.jersey.test-framework.providers</groupId>
 *      <artifactId>jersey-test-framework-provider-inmemory</artifactId>
 *      <version>${jersey2.version}</version>
 *  </dependency>
 *
 * @author Paul Samsotha
 */
public class AcceptLanguageTest extends JerseyTest {

    @Path("language")
    public static class TestResource {

        @GET
        public String get(@Context Locale locale) {
           return locale.toString();
        }
    }

    public static interface LocaleResolver {
        Locale resolveLocale(List<Locale> locales);
    }

    // Note: if you look in the javadoc for getAcceptableLanguages()
    // you will notice that it says if there is not acceptable language
    // specified, that there is a default single wildcard (*) locale.
    // So this implementation sucks, as it doesn't check for that.
    // You will want to make sure to do so!
    public static class DefaultLocaleResolver implements LocaleResolver {

        @Override
        public Locale resolveLocale(List<Locale> locales) {
            if (locales.contains(Locale.ENGLISH)) {
                return Locale.ENGLISH;
            }
            return null;
        }
    }

    @Provider
    @PreMatching
    public static class LocaleResolverFilter implements ContainerRequestFilter {

        static final String LOCALE_PROPERTY = "LocaleResolverFilter.localProperty";

        @Inject
        private LocaleResolver localeResolver;

        @Override
        public void filter(ContainerRequestContext context) throws IOException {
            List<Locale> locales = context.getAcceptableLanguages();
            Locale locale = localeResolver.resolveLocale(locales);
            if (locale == null) {
                context.abortWith(Response.status(Response.Status.NOT_ACCEPTABLE).build());
                return;
            }
            context.setProperty(LOCALE_PROPERTY, locale);
        }
    }

    public static class LocaleFactory implements Factory<Locale> {

        @Context
        private ContainerRequestContext context;

        @Override
        public Locale provide() {
            return (Locale) context.getProperty(LocaleResolverFilter.LOCALE_PROPERTY);
        }

        @Override
        public void dispose(Locale l) {} 
    }

    @Override
    public ResourceConfig configure() {
        return new ResourceConfig(TestResource.class)
                .register(LocaleResolverFilter.class)
                .register(new AbstractBinder() {
                    @Override
                    protected void configure() {
                        bindFactory(LocaleFactory.class)
                                .to(Locale.class).in(RequestScoped.class);
                        bind(DefaultLocaleResolver.class)
                                .to(LocaleResolver.class).in(Singleton.class);
                    }
                })
                .register(new LoggingFilter(Logger.getAnonymousLogger(), true));
    }

    @Test
    public void shouldReturnEnglish() {
        final String accept = "da, en-gb;q=0.8, en;q=0.7";
        final Response response = target("language").request()
                .acceptLanguage(accept)
                .get();
        assertThat(response.readEntity(String.class), is("en"));
    }

    @Test
    public void shouldReturnNotAcceptable() {
        final String accept = "da";
        final Response response = target("language").request()
                .acceptLanguage(accept)
                .get();
        assertThat(response.getStatus(), is(Response.Status.NOT_ACCEPTABLE.getStatusCode()));
    }
}