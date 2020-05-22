@Component
public class TestClient {


  public Flux<Appraisal> firstServiceList() {

    return WebClient.create()
            .get()
            .uri("http://demo4307830.mockable.io/first")
            .accept(MediaType.APPLICATION_JSON)
            .retrieve()
            .bodyToFlux(Appraisal.class);

  }

  public Mono<AppraisalBonus> firstServiceFindId(UUID uuid) {

    return WebClient.create()
            .get()
            .uri("http://demo4307830.mockable.io/"+ uuid)
            .accept(MediaType.APPLICATION_JSON)
            .retrieve()
            .bodyToMono(AppraisalBonus.class);

  }
}