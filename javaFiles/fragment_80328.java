@Component
public class ScheduledTasks {

private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

@Autowired
private SavingsAccountDao savingsAccountDao;

/* each day at 8 am */
@Scheduled(cron = "0 0 8 * * *")
public void increaseSavingsAccount() {
    log.info("Savings Accounts Updated", dateFormat.format(new Date()));

    /* get all savings accounts and increase balance according to the interest */
    List<SavingsAccount> savingsAccountList = savingsAccountDao.findAll();
    savingsAccountList.forEach((sa) -> {

        /* 39% interest in 12 months */
        sa.setASavingsBalance(sa.getASavingsBalance().multiply(new BigDecimal(1.0009)));
    });
}