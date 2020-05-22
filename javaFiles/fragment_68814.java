@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "model_article", catalog = "oogvg", joinColumns = {
            @JoinColumn(name = "model_id", nullable = false, updatable = false) },
            inverseJoinColumns = { @JoinColumn(name = "article_id",
                    nullable = false, updatable = false) })
    public Set<Article> getArticle() {
        return articles;
    }

    public void setArticle(Set<Article> article) {
        this.articles = article;
    }