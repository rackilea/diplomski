public class CaseFilter implements ContainerRequestFilter {

  @Override
  public ContainerRequest filter(ContainerRequest request) {
    for (Entry<String, List<String>> entry: request.getFormParameters().entrySet()) {
      request.getFormParameters().put(entry.getKey().toLowerCase(), entry.getValue());
    }
    return request;
  }

}