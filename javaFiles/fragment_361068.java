static class Builder extends LinkBuilderSupport<Builder> {

    Builder( final UriComponentsBuilder builder ) {
        super( builder );
    }

    @Override
    protected Builder getThis() {
        return this;
    }

    @Override
    protected Builder createNewInstance( final UriComponentsBuilder builder ) {
        return new Builder( builder );
    }
}