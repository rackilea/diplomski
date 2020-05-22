class Root {

    private List<ResourceDescription> resourcedescriptions;

    public List<ResourceDescription> getResourcedescriptions() {
        return resourcedescriptions;
    }

    public void setResourcedescriptions(List<ResourceDescription> resourcedescriptions) {
        this.resourcedescriptions = resourcedescriptions;
    }

    @Override
    public String toString() {
        return String.valueOf(resourcedescriptions);
    }
}