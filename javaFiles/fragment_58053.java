@ThreadSafe
public abstract class CachedI18NMessageBundle
    extends I18NMessageBundle
{
    /**
     * Map pairing locales with {@link FutureTask} instances returning message
     * sources
     *
     * <p>There will only ever be one task associated with one locale; we
     * therefore choose to make it a normal map, guarded by a {@link
     * ReentrantLock}.</p>
     *
     * <p>The tasks' {@link FutureTask#run()} method will be executed the first
     * time this object is initialized.</p>
     */
    @GuardedBy("lock")
    private final Map<Locale, FutureTask<MessageSource>> lookups
        = new HashMap<Locale, FutureTask<MessageSource>>();

    /**
     * Lock used to guarantee exclusive access to the {@link #lookups} map
     */
    private final Lock lock = new ReentrantLock();

    @Override
    protected final List<MessageSource> getSources(final Locale locale)
    {
        FutureTask<MessageSource> task;

        /*
         * Grab an exclusive lock to the lookups map. The lock is held only for
         * the time necessary to grab the FutureTask or create it (and run it)
         * if it didn't exist previously.
         *
         * We can do this, since FutureTask's .run() is asynchronous.
         */
        lock.lock();
        try {
            /*
             * Try and see whether there is already a FutureTask associated with
             * this locale.
             */
            task = lookups.get(locale);
            if (task == null) {
                /*
                 * If not, create it and run it.
                 */
                task = lookupTask(locale);
                lookups.put(locale, task);
                task.run();
            }
        } finally {
            lock.unlock();
        }

        /*
         * Try and get the result for this locale; on any failure event (either
         * an IOException thrown by tryAndLookup() or a thread interrupt),
         * return an empty list.
         */
        try {
            return Arrays.asList(task.get());
        } catch (ExecutionException ignored) {
            return Collections.emptyList();
        } catch (InterruptedException  ignored) {
            return Collections.emptyList();
        }
    }

    protected abstract MessageSource tryAndLookup(final Locale locale)
        throws IOException;

    @Override
    public final Builder modify()
    {
        throw new IllegalStateException("cached bundles cannot be modified");
    }

    /**
     * Wraps an invocation of {@link #tryAndLookup(Locale)} into a {@link
     * FutureTask}
     *
     * @param locale the locale to pass as an argument to {@link
     * #tryAndLookup(Locale)}
     * @return a {@link FutureTask}
     */
    private FutureTask<MessageSource> lookupTask(final Locale locale)
    {
        final Callable<MessageSource> callable = new Callable<MessageSource>()
        {
            @Override
            public MessageSource call()
                throws IOException
            {
                return tryAndLookup(locale);
            }
        };

        return new FutureTask<MessageSource>(callable);
    }
}