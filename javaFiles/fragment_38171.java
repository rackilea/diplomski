static Object fieldOdClass(final String className,
        final String valeurRecherche1) {
        try {
            final Field[] f = Class.forName(className).getFields();
            for (int i = f.length - 1; i >= 0; i--) {
                System.out.println(f[i].toString());
                if (f[i].toString().endsWith(valeurRecherche1)) {
                    return f[i].toString();
                }
            }
        } catch (final ClassNotFoundException e) {
            // manage errors;
        }
    }