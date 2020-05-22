new Address() {
    String postal;
    public void setPostal(String post) {
        postal = post;
    }

    @Override
    public String toString() {
        return "Street: " + street + " | number: " + number
                        + " | town: " + town + " | province: " + province
                        + " | Postal Code: " + postal;
        }
    }
}.setPostal("whatever");