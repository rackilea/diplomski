import java.awt.EventQueue;
import java.awt.SecondaryLoop;
import java.awt.Toolkit;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Supplier;
import javafx.application.Platform;
import javax.swing.SwingUtilities;

public class Foo {

    public static <T> T getOnFxAndWaitOnEdt(Supplier<? extends T> supplier) {
        Objects.requireNonNull(supplier, "supplier");
        if (!EventQueue.isDispatchThread()) {
            throw new IllegalStateException("current thread != EDT");
        }

        final SecondaryLoop loop = Toolkit.getDefaultToolkit()
                .getSystemEventQueue()
                .createSecondaryLoop();
        final AtomicReference<T> valueRef = new AtomicReference<>();

        Platform.runLater(() -> {
            valueRef.set(supplier.get());
            SwingUtilities.invokeLater(loop::exit);
        });
        loop.enter();

        return valueRef.get();
    }

    public static <T> T getOnEdtAndWaitOnFx(Supplier<? extends T> supplier) {
        Objects.requireNonNull(supplier, "supplier");
        if (!Platform.isFxApplicationThread()) {
            throw new IllegalStateException(
                    "current thread != JavaFX Application Thread");
        }

        final Object key = new Object();
        final AtomicReference<T> valueRef = new AtomicReference<>();

        SwingUtilities.invokeLater(() -> {
            valueRef.set(supplier.get());
            Platform.runLater(() -> Platform.exitNestedEventLoop(key, null));
        });
        Platform.enterNestedEventLoop(key);

        return valueRef.get();
    }

}