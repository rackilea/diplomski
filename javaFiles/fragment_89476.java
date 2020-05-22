List<String> strs = Arrays.asList("CRS-ISAU-RPV#3430_Dedalus_Conc.ok.erto_AOTreviglio.doc",
            "CRS-ISAU-RPV#3430_Dedalus_Conc.ok.erto_AOTreviglio.docx",
            "CRS-ISAU-RPV#3430_Dedalus_Conc.ok.erto_AOTreviglio.odt",
            "CRS-ISAU-RPV#3430_Dedalus_Conc.ok.erto_AOTreviglio.ok.docx",
            "CRS-ISAU-RPV#3430_Dedalus_Conc.ok.erto_AOTreviglio.ok.odt"
        );
for (String str : strs) {
    System.out.println("----------\nMatching: " + str);
    Matcher m = Pattern.compile("^([^#]*#[^-_]*)([-_])(.*)$(?<=(?<![.]ok)[.](?:docx?|odt)$)").matcher(str);
    if (m.matches()) {
        System.out.println(m.group(1));
        System.out.println(m.group(2));
        System.out.println(m.group(3));
    } else { System.out.println("No match"); }
}