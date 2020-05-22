class RowData {
    private Stockorder stockorder;
    private Article article;
    public RowData(Arthicle article, Stockorder stockorder) {
        this.article = article;
        this.stockorder = stockorder;
    }
    public Stockorder getStockorder(){ return stockorder; }
    public Article getArticle(){ return arthicle; }
}