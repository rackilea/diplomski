import static java.util.stream.Collectors.toList;
import java.util.ArrayList;
import java.util.List;

static class XObjectWrapper {XObjectWrapper(Object o) {}}
static class XObject {}

public class Test {
  public static void main(String[] args) {
    List<Object> xoList = new ArrayList<>();
    List<XObjectWrapper> wrappedList =
        xoList.stream().map(XObjectWrapper::new).collect(toList());
    System.out.println(wrappedList);
  }
}