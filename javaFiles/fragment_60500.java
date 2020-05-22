@Service
public class AppraisalServiceImpl {

  @Autowired
  private TestClient testClient;

  public Flux<AppraisalCombine> combineTwo() {
    return testClient.firstServiceList()
            .flatMap(appraisal -> testClient.firstServiceFindId(appraisal.getAppraisalId())
                    .flatMap(appraisalBonus -> Mono.just(AppraisalCombine.builder()
                            .appraisalId(appraisalBonus.getAppraisalId())
                            .bonusAmount(appraisalBonus.getBonusAmount())
                            .bonusPaidDate(appraisalBonus.getBonusPaidDate())
                            .employeeId(appraisalBonus.getEmployeeId())
                            .grade(appraisal.getGrade())
                            .score(appraisal.getScore())
                            .status(appraisal.getStatus())
                            .build())));

  }
}