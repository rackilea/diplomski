package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;


public class Main {

    // simplified Brand pojo
    static class Brand {
        int id;
        public Brand(int id) {
            this.id = id;
        }
        public int getId() {
            return id;
        }

        // for output clarity
        @Override
        public String toString() {
            return String.format("Brand: %d", id);
        }
    }

    public static void main(String[] args) throws Exception {

        // simplified ID list
        int[] sortedIdArr = {4,53,102};
        // "randomly" ordered Brand list
        final List<Brand> categories = new ArrayList<Brand>() {  
            {
                add(new Brand(1));
                add(new Brand(102));
                add(new Brand(53));
                add(new Brand(4));
                add(new Brand(0));
            }
        };
        // destination: linked set
        Set<Brand> linked = new LinkedHashSet<Brand>();
        // streaming the ID array in order
        Arrays.stream(sortedIdArr)
            .forEach((i) -> {
                // retrieving a Brand with same ID as the current
                // from the "randomly" ordered list
                Optional<Brand> toAdd = categories.stream()
                .filter((b) -> b.getId() == i)
                .findFirst();
                // making sure there's one
                if (toAdd.isPresent()) {
                    // adding to linked set
                    linked.add(toAdd.get());
                }
            }
        );
        System.out.println(linked);
    }

}