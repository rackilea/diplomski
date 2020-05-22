class CompositeKey {
    private String key1;
    private Integer key2;
    private Double key3;


    public CompositeKey(String key1, Integer key2, Double key3) {
        this.key1 = key1;
        this.key2 = key2;
        this.key3 = key3;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((key1 == null) ? 0 : key1.hashCode());
        result = prime * result + ((key2 == null) ? 0 : key2.hashCode());
        result = prime * result + ((key3 == null) ? 0 : key3.hashCode());
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
        CompositeKey other = (CompositeKey) obj;
        if (key1 == null) {
            if (other.key1 != null)
                return false;
        } else if (!key1.equals(other.key1))
            return false;
        if (key2 == null) {
            if (other.key2 != null)
                return false;
        } else if (!key2.equals(other.key2))
            return false;
        if (key3 == null) {
            if (other.key3 != null)
                return false;
        } else if (!key3.equals(other.key3))
            return false;
        return true;
    }

    public String getKey1() {
        return key1;
    }

    public Integer getKey2() {
        return key2;
    }

    public Double getKey3() {
        return key3;
    }

}