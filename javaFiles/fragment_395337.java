public static void find(Map<String, List<String>> lists, File dir) {
for (File f : dir.listFiles()) {
  if (f.isDirectory()) {
    find(lists, f);
  } else {
      try{
          FileInputStream fi = new FileInputStream(f);
          byte fileData[] = new byte[(int) f.length()];
                fi.read(fileData);
                fi.close();
                //Crearea id unic hash pentru fisierul curent
                String hash = new BigInteger(1, messageDigest.digest(fileData)).toString(16);
                List<String> list = lists.get(hash);
                if (list == null) {
                    list = new LinkedList<String>();
                }
                //Adăugați calea către listă
                list.add(f.getAbsolutePath());
                //Adauga lista actualizată la tabelul Hash
                lists.put(hash, list);

      }catch (IOException e) {
                throw new RuntimeException("cannot read file " + f.getAbsolutePath(), e);
            }

  }
}