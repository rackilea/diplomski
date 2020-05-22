@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="PORTFOLIO_ID", insertable=true, updatable=false)
    public int getId() {
        return this.id;
    }