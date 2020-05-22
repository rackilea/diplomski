public interface Reportfile
{
    public Collection<Pojo> parseReadFile();
}

public final class CsvFile implements Reportfile {
    @Override
    public Collection<Pojo> parseReadFile() {
        Collection<Pojo> result = new ArrayList<>();
        String[] newline;
        try {
            CSVReader reader = new CSVReader(new FileReader(file), delimiter);
            while ((newline = reader.readNext()) != null) {
                result.add(new Pojo(newline));
            }
        } catch (Exception e) {
            log.error("file not found");
        }
        return result;
    }
}