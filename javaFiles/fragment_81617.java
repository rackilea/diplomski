import java.util.*;

import static java.util.Collections.singleton;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toSet;

class Combinations {

    static <T> Set<T> union(Collection<T> lhs, Collection<T> rhs) {
        final Set<T> result = new HashSet<>(lhs);
        result.addAll(rhs);
        return result;
    }

    static <T> String collToString(Collection<T> l) {
        return l.stream()
            .map(Object::toString)
            .collect(joining(",", "{", "}"));
    }

    static <T> Set<Set<T>> value(T value) {
        return singleton(singleton(value));
    }

    static <T> Set<Set<T>> or(Set<Set<T>> lhs, Set<Set<T>> rhs) {
        return union(lhs, rhs);
    }

    static <T> Set<Set<T>> and(Set<Set<T>> lhs, Set<Set<T>> rhs) {
        return lhs.stream()
            .flatMap(ls -> rhs.stream().map(rs -> union(ls, rs)))
            .collect(toSet());
    }

    static class Choose<T> {
        private static int binomial(final int n, final int r) {
            int ret = 1;
            for (int k = 0; k < r; k++) {
                ret = ret * (n-k) /(k+1);
            }
            return ret;
        }

        static <T> Optional<Choose<T>> of(Set<Set<T>> sst) {
            final Set<Integer> sizes = sst.stream().map(Set::size).collect(toSet());
            if (sizes.size() != 1) {
                return Optional.empty();
            } else {
                final int r = sizes.iterator().next();
                final Set<T> values = sst.stream().flatMap(Set::stream).collect(toSet());
                final int n = values.size();
                final int ncr = binomial(n, r);
                if (sst.size() == ncr) {
                    return Optional.of(new Choose<>(values, r));
                } else {
                    return Optional.empty();
                }
            }
        }

        public final Set<T> values;

        public final int r;

        Choose(Set<T> values, int r) {
            this.values = values;
            this.r = r;
        }

        @Override
        public String toString() {
            return collToString(values) + " " + r + " of " + values.size();
        }
    }

    public static void main(String[] args) {
        // Generate the combinations.
        final Set<Set<String>> combos =
            or(
                or(
                    and(value("A"), value("B")),
                    and(value("C"), value("D"))
                ), and(
                    or(value("A"), value("B")),
                    or(value("C"), value("D"))
                )
            );

        // Print the combinations to stdout.
        combos.stream()
            .map(ss -> collToString(ss))
            .forEach(System.out::println);

        Optional<Choose<String>> choose = Choose.of(combos);
        System.out.println(choose);
    }
}