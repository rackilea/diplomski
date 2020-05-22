@ManyToOne
    @JoinColumn(name="STORE_ID", referencedColumnName="STORE_ID")
    private Store store;

    @ManyToOne
    @JoinColumn(name="CUST_ID", referencedColumnName="CUST_ID")
    private Customer customer;

    @OneToMany(mappedBy="invoice",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    private List<InvoiceLine> lines;

    @ManyToOne
    @JoinColumn(name="TECH_ID",referencedColumnName="TECH_ID")
    private Technician technician;