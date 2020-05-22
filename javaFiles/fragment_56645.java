public enum RestrictedComboEnum {

Barbarian(new String[] { "bard", "druid" }), 
Dwarf(new String[] { "hello","trial" });

RestrictedComboEnum(String[] classes) {
    this.classes = classes;
}

String[] classes;

public String[] getClasses() {
    return this.classes;
}