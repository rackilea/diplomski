try{FileOutputStream out = new FileOutputStream(
                    new File(System.getProperty("user.dir") + "\\needful\\output.xlsx"));
            workbook.write(out);
            workbook.close();
            out.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }