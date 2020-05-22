import java.util.List;
import java.util.Arrays;

public <T> Iterator<T> iterator() {
    List<T> list = (List<T>) Arrays.asList(all_objs);

    return list.iterator();
}