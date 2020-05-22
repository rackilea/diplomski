@Service
@Transactional
@Retryable(maxAttempts = 7, 
            backoff = @Backoff(delay = 50), 
            include = { TransientDataAccessException.class,
                        RecoverableDataAccessException.class }
)
public class MyService {

    // all methods in this service are now transactional and automatically retried.

}