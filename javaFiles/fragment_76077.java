public void doStuff() {
    CompositeKeyHolder keyHolder = new CompositeKeyHolder();
    ... same code here ...

    keyHolder.getCompositeKey();
}


class CompositeKeyHolder extends GeneratedKeyHolder {
    private boolean converted;

    public CompositeKey getCompositeKey() {
        return new CompositeKey((Integer)this.getKeys().get("id"), (Integer)this.getKeys().get("otherid"));
    }
}


class CompositeKey {

    private Integer id;

    private Integer otherId;

    CompositeKey(Integer id, Integer otherId) {
        this.id = id;
        this.otherId = otherId;
    }

    public Integer getId() {
        return id;
    }

    public Integer getOtherId() {
        return otherId;
    }

}