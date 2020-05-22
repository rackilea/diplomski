private List<Movs> latestIncomes;
private AtomicInteger counter = new AtomicInteger();

@PostConstruct
public void init() {
    latestIncomes = cajaFacade.getLatestIncomes(20);
}

public List<Movs> getlatestIncomes() {
    System.err.printf("Get call #%d during phase %s%n", counter.incrementAndGet(), 
        FacesContext.getCurrentInstance().getCurrentPhaseId());
    Thread.dumpStack();

    return latestIncomes;
}