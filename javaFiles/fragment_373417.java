File f = new File(c.getFilesDir().getPath()
                        + "/calculmobiledex.jar");
                Log.i("File", "" + f.exists());

                DexClassLoader u = new DexClassLoader(f.toURI().toURL()
                        .toString(), c.getDir("libs", c.MODE_PRIVATE)
                        .getAbsolutePath(), null,
                        ClassLoader.getSystemClassLoader());
                Class c = u.loadClass("perimetre.calcul");

                Constructor constru = c
                        .getConstructor(int.class, int.class);
                Object o = constru.newInstance(2, 2);
                Method m = c.getMethod("resultat", int.class, int.class);
                m.setAccessible(true);

                Log.i("method = ", "" + m.invoke(o, 1, 1));
                m = null;