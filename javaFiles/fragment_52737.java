@Column(name = "TICKET_ID", nullable = false)
public Long getTicketId() {
     return ticketId;
}

public void setTicketId(Long ticketId) {
     this.ticketId = ticketId;
}

@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "TICKET_ID", nullable = false, insertable = false, updatable = false)
public Ticket getTicket() {
    return this.ticket;
}

public void setTicket(TktTicket ticket) {
    this.ticket= ticket;
}