import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class MyCollection<T, TPrimaryKey, TSecondaryKey extends Comparable<TSecondaryKey>> {
    private HashMap<TPrimaryKey, T> primaryKeyMap;
    private List<PrimarySecondaryKeyPair> primarySecondaryKeyList;

    public MyCollection() {
        primaryKeyMap = new HashMap<TPrimaryKey, T>();
        primarySecondaryKeyList = new ArrayList<PrimarySecondaryKeyPair>();
    }

    public MyCollection(int initialCapacity) {
        primaryKeyMap = new HashMap<TPrimaryKey, T>(initialCapacity);
        primarySecondaryKeyList = new ArrayList<PrimarySecondaryKeyPair>(initialCapacity);
    }

    private class PrimarySecondaryKeyPair implements Comparable<PrimarySecondaryKeyPair> {
        public TPrimaryKey primaryKey;
        public TSecondaryKey secondaryKey;

        public PrimarySecondaryKeyPair(TPrimaryKey primaryKey, TSecondaryKey secondaryKey) {
            this.primaryKey = primaryKey;
            this.secondaryKey = secondaryKey;
        }

        @Override
        public int compareTo(MyCollection<T, TPrimaryKey, TSecondaryKey>.PrimarySecondaryKeyPair o) {
            return secondaryKey.compareTo(o.secondaryKey);
        }
    }

    public void put(T object, TPrimaryKey primaryKey, TSecondaryKey secondaryKey) { // put by primaryKey
        primaryKeyMap.put(primaryKey, object);
        PrimarySecondaryKeyPair keyPair = new PrimarySecondaryKeyPair(primaryKey, secondaryKey);
        int insertionPoint = Collections.binarySearch(primarySecondaryKeyList, keyPair);
        primarySecondaryKeyList.add((insertionPoint > -1) ? insertionPoint : (-insertionPoint) - 1, keyPair);
    }

    public T getByPrimaryKey(TPrimaryKey primaryKey) {
        return primaryKeyMap.get(primaryKey);
    }

    public T getByIndex(int index) {
        return getByPrimaryKey(primarySecondaryKeyList.get(index).primaryKey);
    }

    public void deleteByPrimaryKey(TPrimaryKey primaryKey) {
        primaryKeyMap.remove(primaryKey);
        for (int i = 0; i < primarySecondaryKeyList.size(); i++) {
            if (primarySecondaryKeyList.get(i).primaryKey.equals(primaryKey)) {
                primarySecondaryKeyList.remove(i);
            }
        }
    }

    public void deleteByIndex(int index) {
        primaryKeyMap.remove(primarySecondaryKeyList.remove(index).primaryKey);
    }
}