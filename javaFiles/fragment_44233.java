import org.apache.commons.lang3.tuple.Pair;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;

Multiset<Pair<String, String>> set = HashMultiset.create();
for (int i = 0; i < List2.size(); i++) {
    set.add(Pair.of(List1.get(i), List2.get(i)));
}
System.out.println(set);