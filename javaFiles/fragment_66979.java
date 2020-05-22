private final AtomicMarkableReference<Double> saldo = new AtomicMarkableReference<>(0.0, true);

@Override
public boolean setInctive() {
    return saldo.attemptMark(0.0, false);
}