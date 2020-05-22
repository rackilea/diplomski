public int compareTo(Crawford_Diamond other) {
        if (getCarot() < other.getCarot()) {
            return 1;
        } else if (getCarot() > other.getCarot()) {
            return -1;
        }

        if (this.color < other.getColor()) {
            return 1;
        } else if (this.color > other.getColor()) {
            return -1;
        }

        if (this.clarity.compareTo(other.getClarity())<1) {
            return 1;
        } else if (this.clarity.compareTo(other.getClarity())>1) {
            return -1;
        }
        return 0;
    }