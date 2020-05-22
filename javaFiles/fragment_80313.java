import java.io.FileFilter;       // Aren't name collisions fun?
import java.io.FilenameFilter;
import java.util.Comparator;
import java.util.logging.Filter;

/*

Interface                        Single Abstract Method     
---------                        ----------------------
KeyEventDispatcher:              boolean dispatchKeyEvent(KeyEvent e);
KeyEventPostProcessor:           boolean postProcessKeyEvent(KeyEvent e);
FileFilter:                      boolean accept(File pathname);
FilenameFilter:                  boolean accept(File dir, String name);
Thread.UncaughtExceptionHandler: void uncaughtException(Thread t, Throwable e);
DirectoryStream<T>.Filter<T>:    boolean accept(T entry) throws IOException;
PathMatcher:                     boolean matches(Path path);
TemporalAdjuster:                Temporal adjustInto(Temporal temporal);
TemporalQuery<R>:                R queryFrom(TemporalAccessor temporal);
Comparator<T>:                   int compare(T o1, T o2);
Filter:                          public boolean isLoggable(LogRecord record);
PreferenceChangeListener:        void preferenceChange(PreferenceChangeEvent evt);    

*/