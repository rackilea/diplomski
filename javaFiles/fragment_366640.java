class myStackReverse<E> extends Stack<E> {
    public String toStringReverse() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        if (this.size() > 0) {
            sb.append(this.get(this.size()-1));
        }
        for (int i = this.size()-2; i>=0; i--) {
            sb.append(", ");
            sb.append(this.get(i));
        }
        sb.append("]");
        return sb.toString();
    }
}