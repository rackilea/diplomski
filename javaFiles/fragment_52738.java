@Column(name = "TKT_TICKET_ID", nullable = false, insertable = false, updatable = false)
    public Long getTicketId() {
        return ticketId;
    }

    public void setTicketId(Long ticketId) {
        this.ticketId = ticketId;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TKT_TICKET_ID", nullable = false)
    public TktTicket getTktTicket() {
        return this.tktTicket;
    }

    public void setTktTicket(TktTicket tktTicket) {
        this.tktTicket = tktTicket;
    }