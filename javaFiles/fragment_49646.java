PrimitiveDenseStore m1 = PrimitiveDenseStore.FACTORY.makeZero(10, 10);
PrimitiveDenseStore m2 = PrimitiveDenseStore.FACTORY.makeZero(3, 3);

m2.add(0, 0, 5D);
m2.add(1, 1, 2D);
m2.add(1, 2, 3D);
m2.add(2, 1, -10D);

m1
    .regionByColumns(4, 5, 6)
    .regionByRows(4, 5, 6)
    .modifyMatching(PrimitiveMath.ADD, m2);

assertThat(m1.aggregateAll(MINIMUM)).isEqualTo(5);