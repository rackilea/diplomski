public static void main(final String[] args) throws IOException
   {
      Album al = new Album();
      List<Row> rows = new ArrayList<Row>();
      final Row row1 = new Row();
      row1.areaId = "area1";
      row1.nameEng = "eng1";
      row1.nameGer = "ger1";
      final Row row2 = new Row();
      row2.areaId = "area2";
      row2.nameEng = "eng2";
      row2.nameGer = "ger2";
      rows.add(row2);
      rows.add(row1);
      al.status = "stat";
      al.rows = rows;
      final File file = new File("D:/test.xml");
      final FileOutputStream out = new FileOutputStream(file);

      JAXB.marshal(al, out);  

      final Album after = JAXB.unmarshal(file, Album.class);
      assert after.status.equals(al.status);
      assert after.rows.size() == al.rows.size();
   }