try {
                String a = "&nbsp;December 2011&nbsp;";
                a = a.replace("&nbsp;", "");
                SimpleDateFormat sdf = new SimpleDateFormat("MMMMM yyyy");
                SimpleDateFormat SdfParser = new SimpleDateFormat("yyyy-MM-dd");

                String date =SdfParser.format(sdf.parse(a)); 
                System.out.println(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }