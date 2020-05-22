import io.vavr.collection.Iterator;
import io.vavr.collection.List;
...

List<Product> filter(Collection<Product> products) {
    return Iterator.ofAll(products)
        .filter(pred1)
        .collect(List.collector());
}