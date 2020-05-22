@HystrixCommand(fallbackMethod = "getFareBackup")
@RequestMapping("/dashboard")
public String getFareDashboard(Model m) {

    ResponseEntity<List<BusFare>> responseEntity = restTemplate.exchange("http://busfare-service/api/v1/fare/",
                HttpMethod.GET, null, new ParameterizedTypeReference<List<BusFare>>() {
                });

    m.addAttribute("fareList", responseEntity.getBody());

    return "dashboard";
}