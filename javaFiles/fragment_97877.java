public class DomainSelectFieldFactory extends SelectFieldFactory {
@Override
public List<SelectFieldOptionDefinition> getSelectFieldOptionDefinition() {
    List<SelectFieldOptionDefinition> options = new ArrayList<SelectFieldOptionDefinition>();
    List<Domain> allDomains = getAllDomains(); 
    for (Domain domain : allDomains) {
        SelectFieldOptionDefinition option = new SelectFieldOptionDefinition();
        option.setValue(domain.id);
        option.setLabel(domain.name);
        options.add(option);
     }
    return options;
} ...



public class DomainSelectFieldDefinition extends SelectFieldDefinition {

public DomainSelectFieldDefinition() {
    setTransformerClass((Class<? extends Transformer<?>>) (Object) BasicTransformer.class);
}