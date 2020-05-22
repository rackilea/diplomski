@Override
    public int compareTo(MatchDescription other) {
        if (this.matchType == other.matchType)
            if (this.matchOrder == other.matchOrder)
                return (this.subMatchOrder - other.subMatchOrder);
            else
                return (this.matchOrder - other.matchOrder);
        else
            return (this.matchType.getMatchTypeOrder() - other.matchType.getMatchTypeOrder());  
    }

    @Override
    public boolean equals(Object other) {
        return (other instanceof MatchDescription) &&
                (((MatchDescription) other).matchType == this.matchType) &&
                (((MatchDescription) other).matchOrder == this.matchOrder);
    }