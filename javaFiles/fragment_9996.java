public final class EditableRxTextView {
    @CheckResult
    @NonNull
    public static InitialValueObservable<CharSequence> textChanges(@NonNull TextView view) {
        return new EditableTextViewTextObservable(view);
    }
}