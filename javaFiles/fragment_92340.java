private List<CragEntity> crags;

    @OneToMany(mappedBy = "subRegion")
    List<CragEntity> getCrags() {
        return crags;
    }

    public void setCrags(List<CragEntity> crags) {
        this.crags = crags;
    }