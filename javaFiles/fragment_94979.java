package com.mypackage.jpa.util;

    import java.io.File;
    import java.net.URL;
    import java.util.ArrayList;
    import java.util.List;

    import org.hibernate.cfg.Configuration;
    import org.hibernate.tool.hbm2ddl.SchemaExport;

    public class SchemaGenerator {

        private Configuration cfg;

        public static void main(String[] args) throws Exception {

            File f = new File(".");
            String directory = f.getAbsoluteFile() + "/src/main/resources/ddl/generated/";

            String packageName[] = { "com.mypackage.jpa", "com.mypackage.jpa.legacy", "com.mypackage.jpa.local",
                    "com.mypackage.jpa.local.impl" };

            SchemaGenerator gen = new SchemaGenerator(packageName);
            gen.generate(Dialect.MYSQL, directory);

        }

        @SuppressWarnings("rawtypes")
        public SchemaGenerator(String[] packagesName) throws Exception {
            cfg = new Configuration();
            cfg.setProperty("hibernate.hbm2ddl.auto", "create");

            for (String packageName : packagesName) {
                for (Class clazz : getClasses(packageName)) {
                    cfg.addAnnotatedClass(clazz);
                }
            }
        }

        @SuppressWarnings("rawtypes")
        private List<Class> getClasses(String packageName) throws Exception {
            File directory = null;
            try {
                ClassLoader cld = getClassLoader();
                URL resource = getResource(packageName, cld);
                directory = new File(resource.getFile());
            } catch (NullPointerException ex) {
                throw new ClassNotFoundException(packageName + " (" + directory + ") does not appear to be a valid package");
            }
            return collectClasses(packageName, directory);
        }

        private ClassLoader getClassLoader() throws ClassNotFoundException {
            ClassLoader cld = Thread.currentThread().getContextClassLoader();
            if (cld == null) {
                throw new ClassNotFoundException("Can't get class loader.");
            }
            return cld;
        }

        private URL getResource(String packageName, ClassLoader cld) throws ClassNotFoundException {
            String path = packageName.replace('.', '/');
            URL resource = cld.getResource(path);
            if (resource == null) {
                throw new ClassNotFoundException("No resource for " + path);
            }
            return resource;
        }

        @SuppressWarnings("rawtypes")
        private List<Class> collectClasses(String packageName, File directory) throws ClassNotFoundException {
            List<Class> classes = new ArrayList<>();
            if (directory.exists()) {
                String[] files = directory.list();
                for (String file : files) {
                    if (file.endsWith(".class")) {
                        // removes the .class extension
                        classes.add(Class.forName(packageName + '.' + file.substring(0, file.length() - 6)));
                    }
                }
            } else {
                throw new ClassNotFoundException(packageName + " is not a valid package");
            }
            return classes;
        }

        private void generate(Dialect dialect, String directory) {
            cfg.setProperty("hibernate.dialect", dialect.getDialectClass());
            SchemaExport export = new SchemaExport(cfg);
            export.setDelimiter(";");
            export.setOutputFile(directory + "ddl_" + dialect.name().toLowerCase() + ".sql");
            export.setFormat(true);
            export.execute(true, false, false, false);
        }

        private static enum Dialect {
            ORACLE("org.hibernate.dialect.Oracle10gDialect"), MYSQL("org.hibernate.dialect.MySQLDialect"), HSQL(
                    "org.hibernate.dialect.HSQLDialect"), H2("org.hibernate.dialect.H2Dialect");

            private String dialectClass;

            private Dialect(String dialectClass) {
                this.dialectClass = dialectClass;
            }

            public String getDialectClass() {
                return dialectClass;
            }
        }
    }