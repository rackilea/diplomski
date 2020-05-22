@Slf4j
@Service
@Primary
@Qualifier("kakao")
public class KakaoBookService implements BookService {}


@Service
@Qualifier("naver")
public class NaverBookService implements BookService {}