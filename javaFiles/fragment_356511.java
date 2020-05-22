public class MyJwtTokenStore extends JwtTokenStore {

@Autowired
UserRepository userRepository;

public MyJwtTokenStore(JwtAccessTokenConverter jwtTokenEnhancer) {
    super(jwtTokenEnhancer);
}

@Override
public void storeRefreshToken(OAuth2RefreshToken refreshToken, OAuth2Authentication authentication) {
    String username = authentication.getUserAuthentication().getName();
    User user = userRepository.findByEmail(username);
    user.setToken(refreshToken.getValue());
    userRepository.save(user);
}

@Override
public OAuth2RefreshToken readRefreshToken(String token) {
    OAuth2Authentication authentication = super.readAuthentication(token);
    String username = authentication.getUserAuthentication().getName();
    User user = userRepository.findByEmail(username);
    if (!token.equals(user.getToken())) {
        return null;
    }
    OAuth2RefreshToken refreshToken = new DefaultOAuth2RefreshToken(token);
    return refreshToken;
}

@Override
public void removeRefreshToken(OAuth2RefreshToken token) {
    OAuth2Authentication authentication = super.readAuthentication(token.getValue());
    String username = authentication.getUserAuthentication().getName();
    User user = userRepository.findByEmail(username);
    user.setToken(null);
    userRepository.save(user);
}