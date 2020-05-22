interface ExcelSheetWriter {
    void writeOneSheet(String excelFileName);
}

@Configuration
class Config {
    @Bean(name="sheet1Writer) ExcelWriter getSheet1Writer() {
        return new Sheet1Writer(); //implements ExcelWriter
    }
}

class ExcelDocumentWriter {
    @Autowired @Qualifier("sheet1Writer") ExcelWriter sheet1Writer;
    @Autowired @Qualifier("sheet2Writer") ExcelWriter sheet2Writer;
    @Autowired @Qualifier("sheet3Writer") ExcelWriter sheet3Writer;
    //... use them to write the entire document
}