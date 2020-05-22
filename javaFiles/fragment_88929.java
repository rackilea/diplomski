class MyBooleanArray {
    private boolean[] arr;

    public MyBooleanArray(boolean[] arr) {
        this.arr = arr;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Arrays.hashCode(arr);
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
        MyBooleanArray other = (MyBooleanArray) obj;
        if (!Arrays.equals(arr, other.arr))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "MyBooleanArray [arr=" + Arrays.toString(arr) + "]";
    }   
}