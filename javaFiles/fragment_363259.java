class A {
    String name;
    String address;

    String getName() {
        return name;
    }

    String getAddress() {
        return address;
    }

    String getDescription() {
        return name + " " + address;
    }
}

class B extends A {
    String country;
    @Override
    String getAddress() {
        return super.getAddress() + ", " + country;
    }
}