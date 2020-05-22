private MockMvc mockMvc;

@Autowired
private Authentication authentication;   
@Bean
public Authentication authentication() {
    Collection<GrantedAuthority> authorities = new ArrayList<>();
    authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
    UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken("customUsername", "customPassword", authorities); return authentication; }