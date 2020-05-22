@Autowired
protected TokenStore tokenStore;

@RequestMapping(method = RequestMethod.POST, value = "/revoke")
public void revokeToken(@RequestParam String token) {
    ((InMemoryTokenStore)tokenStore).removeRefreshToken(token);
}