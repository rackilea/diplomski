File baseDir = new File(baseDirectory);
File addOnDir = new File(baseDir, addOn);

String canonicalPath = addOnDir.getCanonicalPath();

System.out.println(canonicalPath); // /data/data/org.hacktivity.datatemple