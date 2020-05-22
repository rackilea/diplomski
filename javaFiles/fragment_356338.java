public static void main(String[] args) { 
            JarFile jar = null; 
            try { 
                    jar = new JarFile("plugin.jar"); 
            } catch (IOException e) { 
                    e.printStackTrace(); 
            } 
            ZipFile zipFile = null; 
            try { 
                    zipFile = new ZipFile("plugin.jar"); 
            } catch (IOException e) { 
                    e.printStackTrace(); 
            } 

            final ZipEntry manifestEntry = zipFile.getEntry("META-INF/MANIFEST.MF"); 

            Manifest smActual = null; 
            Manifest smExpected = null; 
            try { 
                    smActual = new Manifest(jar.getInputStream(manifestEntry)); 
                    smExpected = new Manifest(new FileInputStream("META-INF/MANIFEST.MF")); 
            } catch (IOException e) { 
                    e.printStackTrace(); 
            } 


            if(smActual.equals(smExpected)) { 
                    System.out.println("Yes Equal"); 
            } else { 
                    System.out.println("They are not equal"); 
            } 

    }