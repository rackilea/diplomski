import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

...

if (lock instanceof ReadLock) {
  System.out.println("Read");
} else if (lock instanceof WriteLock) {
  System.out.println("Write");
}