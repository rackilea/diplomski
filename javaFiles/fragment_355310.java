/**
 * Directory entry deleted.
 *
 * <p> When a directory is registered for this event then the {@link WatchKey}
 * is queued when it is observed that an entry is deleted or renamed out of
 * the directory. The event {@link WatchEvent#count count} for this event
 * is always {@code 1}.
 */
public static final WatchEvent.Kind<Path> ENTRY_DELETE =
    new StdWatchEventKind<Path>("ENTRY_DELETE", Path.class);