// Linux platforms support a normal (non-forcible) kill signal.
static final boolean SUPPORTS_NORMAL_TERMINATION = true;

...

@Override

public boolean supportsNormalTermination() {
    return ProcessImpl.SUPPORTS_NORMAL_TERMINATION;
}