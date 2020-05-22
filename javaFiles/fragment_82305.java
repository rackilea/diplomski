@Autowired
private GatewaysService gatewaysService;

    @GetMapping("gateways")
        public Map<String,String> getGateways() {
            return gatewaysService.getGatewaysList();
        }