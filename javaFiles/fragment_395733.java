ObjectA A = new ObjectA(1, "ABC", new AddressA("jkl"));
ObjectB B = new ObjectB(1, "PQR", new AddressB("xyz"));

assertThat(A, hasProperty("id", equalTo(B.getId())));
assertThat(A, hasProperty("name", equalTo(B.getName())));
assertThat(A.getAddressA(), hasProperty("address", equalTo(B.getAddressB().getAddress())));