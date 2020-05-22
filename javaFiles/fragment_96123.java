String s = "The following images failed: [T430040.tif, T432040.tif, T411030.tif, CH1090.tif, T432050.tif, T432090.tif, T432020.tif, CRP040.tif, T432070.tif, T040060.tif]";
Pattern p = Pattern.compile("\\w+(?=\\.)");
Matcher m = p.matcher(s);
while(m.find()) {
    System.out.println(m.group());
}