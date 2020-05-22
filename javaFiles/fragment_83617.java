* A {@link RejectedExecutionHandler} that blocks the caller until
 * the executor has room in its queue, or a timeout occurs (in which
 * case a {@link RejectedExecutionException} is thrown.
 *
 * @author Gary Russell
 * @since 3.0.3
 *
 */
public class CallerBlocksPolicy implements RejectedExecutionHandler {