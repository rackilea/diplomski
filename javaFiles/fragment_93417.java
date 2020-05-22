public boolean equals(Object obj) {
        if(obj instanceof Product) {
            Product that = (Product) obj;
            return this.id ==that.id;
        }
        return false;
    }