public static Map getImgs(HSSFWorkbook wb) {

   Map hm1 = new HashMap<String, ArrayList<Somename>>();
    HSSFSheet sheet = wb.getSheetAt(2);
    Iterator<Row> iterator= sheet.iterator();
    ArrayList<Somename> al = new ArrayList<Somename>();
    while (iterator.hasNext()) {
        Row row = iterator.next();

        String sno = new DataFormatter().formatCellValue(row.getCell(0));


        if (hm1.get(sno) == null) {
            hm1.put(sno, new ArrayList());
        }

        String some= new DataFormatter().formatCellValue(row
                .getCell(1));

        Somename img1 = new Somename(some);
        System.out.println(img1);

        ArrayList r = (ArrayList) hm1.get(sno);
        r.add(img1);

    }
    return hm1;
    }