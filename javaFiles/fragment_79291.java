import org.springframework.batch.item.file.transform.DefaultFieldSetFactory;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.batch.item.file.transform.FieldSetFactory;
import org.springframework.batch.item.file.transform.LineTokenizer;

public class SectionLineTokenizer implements LineTokenizer {

    private final String nameField = "name";
    private final FieldSetFactory fieldSetFactory = new DefaultFieldSetFactory();

    @Override
    public FieldSet tokenize(String line) {
        String name = line.replaceAll("\\[", "").replaceAll("\\]", "").trim();

        return fieldSetFactory.create(new String[] { name },
                new String[] { nameField });
    }
}