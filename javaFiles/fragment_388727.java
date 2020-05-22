class PojoRequest {
    @ValidInteger(message = "id is faulty")
    private Object id;
    public int getId() {
        return (int) id;
    }

    public void setStartHour(Object id) {
        this.id = id;
    }
}