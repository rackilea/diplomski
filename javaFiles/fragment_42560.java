SimpleDateFormat sdf = new SimpleDateFormat(); // uses default locale (here for Germany)
System.out.println(sdf.toPattern()); // dd.MM.yy HH:mm
System.out.println(sdf.toLocalizedPattern()); // tt.MM.uu HH:mm

DateFormatSymbols dfs = DateFormatSymbols.getInstance(Locale.GERMANY);
dfs.setLocalPatternChars("GJMTkHmsSEDFwWahKzZYuXL");
sdf.setDateFormatSymbols(dfs);
sdf.applyLocalizedPattern("TT.MM.JJJJ");

System.out.println(sdf.toPattern()); // dd.MM.yyyy
System.out.println(sdf.toLocalizedPattern()); // TT.MM.JJJJ
System.out.println(sdf.format(new Date())); // 20.06.2016