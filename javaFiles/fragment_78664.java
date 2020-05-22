@Value("#{'${issues}'.split(',')}")
private List<String> issues;

@RequestMapping(value = "/issueTypes", produces = MediaType.APPLICATION_JSON_VALUE)
public Map<String, List<Map.Entry<String, String>>> getIssue() {
    Map<String, List<Map.Entry<String, String>>> m = new LinkedHashMap<>();
    m.put("Issues", issues.stream()
            .map(s -> Map.entry("issueName", s))
            .collect(Collectors.toList()));
    return m;
}