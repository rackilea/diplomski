import java.util.Comparator;

public class Entity implements Comparable {
private String name;
private int count;

public String getName() {
    return name;
}

public void setName(String name) {
    this.name = name;
}

public int getCount() {
    return count;
}

public void setCount(int count) {
    this.count = count;
}

@Override
public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + count;
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    return result;
}

@Override
public boolean equals(Object obj) {
    if (this == obj)
        return true;
    if (obj == null)
        return false;
    if (getClass() != obj.getClass())
        return false;
    Entity other = (Entity) obj;
    if (count != other.count)
        return false;
    if (name == null) {
        if (other.name != null)
            return false;
    } else if (!name.equals(other.name))
        return false;
    return true;
}

public static Comparator<Entity> ArraylistComparator = new Comparator<Entity>() {

    public int compare(Entity e1, Entity e2) {
        int count1 = e1.getCount();
        int count2 = e2.getCount();

        // ascending order
        return e1.compareTo(e2);

    }
};

@Override
public int compareTo(Object o) {
    int compareCount = ((Entity) o).getCount();
    /* For Ascending order */
    return this.count - compareCount;

    /* For Descending order do like this */
    // return compareCount - this.count;
}

@Override
public String toString() {
    return "Entity [name=" + name + ", count=" + count + "]";
}

}