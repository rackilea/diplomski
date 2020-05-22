class Owner {
    private Content content;

    // ...unnecessary detail omitted...

    public Content getContent() {
        return new Content(this.content);
    }
}