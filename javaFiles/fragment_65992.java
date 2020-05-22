class Person {

    @PreRemove
    protected void makeHouseOnSale() {
        if (owning!= null) {
            owning.owner = null;
        }
    }

    @OneToOne       
    private House owning;
}

class House {
    @OneToOne(
        //optional = true; // default
    )
    private Person owner;
}