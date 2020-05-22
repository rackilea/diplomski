import java.util.Comparator;

public class ModuleSorter implements Comparator<Module> {

    @Override
    public int compare(Module module1, Module module2) {
        return Integer.valueOf(module2.getName().length()).compareTo(module1.getName().length());
    }

}