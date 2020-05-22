import java.util.*;
java.util.List<String> list = Arrays.asList("a", "b", "c");
textFont(loadFont("UMingCN-30.vlw"));
for(int i = 0; i < list.size(); i++) {
  text(list.get(i), 5, int(i*30)+30);
}