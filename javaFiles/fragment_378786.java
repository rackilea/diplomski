private final class DelegateValuesStorage {
    private final Map<Object, Integer> values = new HashMap<Object, Integer>();

    ....

    //Add value or increase a count if exists
    public void add(final Object value) {
       Integer count = values.get(value);
       if (count == null) {
          values.put(value, 1);
       } else {
          values.put(value, count + 1);
       }
    }

    ....

    //Decrease a count or remove value if it doesn't exist anymore
    public void decreaseCount(final Object value) {
        if(value == null) {
            return;
        }
        Integer count = values.get(value);
        if (count == null) {
            // decreasing a "new" value - could be an error too
            return;
        }
        if (count <= 1) {
            // remove the value from the map
            values.remove(value);
        } else {
            values.put(value, count - 1);
        }
    }
}