new ToIntFunction<MyPerson>() {
    @Override
    public int applyAsInt(MyPerson p) {
        return p.getAge();
    }
}