@OneToMany(mappedBy = "callRedirect", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
@PrivateOwned
private List<CallRedirectGroup> callRedirectGroupEntity;



@ManyToOne
@JoinColumn(name = "redirect_id")
private CallRedirect callRedirect;