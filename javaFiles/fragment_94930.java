package com.somepackage;

import java.io.InputStream;
import java.util.Collections;
import java.util.List;

import net.sf.jasperreports.engine.JRPropertiesMap;
import net.sf.jasperreports.extensions.ExtensionsRegistry;
import net.sf.jasperreports.extensions.ExtensionsRegistryFactory;
import net.sf.jasperreports.repo.InputStreamResource;
import net.sf.jasperreports.repo.RepositoryService;
import net.sf.jasperreports.repo.Resource;

/**
 * JasperReports extension factory that enables to read from classpath. Only tries to resolve URLs that start with "classpath:".
 */
public class ClasspathExtensionsRegistryFactory implements ExtensionsRegistryFactory {

    @Override
    public ExtensionsRegistry createRegistry(String registryId, JRPropertiesMap properties) {
        return extFactory;
    }

    private static final ClasspathRepositoryService service = new ClasspathRepositoryService();
    private static final List<ClasspathRepositoryService> services = Collections.singletonList(service);
    private static final ExtensionsRegistry extFactory = new ExtensionsRegistry() {
        @SuppressWarnings("unchecked")
        @Override
        public <T> List<T> getExtensions(Class<T> extensionType) {
                        if (RepositoryService.class.equals(extensionType)) {
                            return (List<T>) services;
                        }
                        return null;
                }
    };

    /**
     * RepositoryService that reads resources from classpath.
     */
    public static class ClasspathRepositoryService implements RepositoryService {

        private static final String CLASSPATH_PREFIX = "classpath:";
        private static final int CLASSPATH_PREFIX_LENGTH = CLASSPATH_PREFIX.length();

        @Override
        public Resource getResource(String uri) {
            return getResource(uri, InputStreamResource.class);
        }

        @Override
        public void saveResource(String uri, Resource resource) {
            //No-op
        }

        @SuppressWarnings("unchecked")
        @Override
        public <K extends Resource> K getResource(String uri, Class<K> resourceType) {
            if (resourceType != null && InputStreamResource.class.equals(resourceType) && uri != null && uri.trim().startsWith(CLASSPATH_PREFIX)) {
                InputStream is = this.getClass().getResourceAsStream(uri.trim().substring(CLASSPATH_PREFIX_LENGTH));
                if (is != null) {
                    InputStreamResource isr = new InputStreamResource();
                    isr.setInputStream(is);
                    isr.setName(uri);
                    return (K)isr;
                }
            }
            return null;
        }

    }

}