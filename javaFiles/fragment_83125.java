@Override
    public int compareTo(Node that)
    {
        if (this.parent != null && that.parent != null) {
            return this.parent.compareTo(that.parent);
        }
        return this.cost - that.cost;
    }