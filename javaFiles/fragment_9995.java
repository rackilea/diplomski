public class EditableTextViewTextObservable extends InitialValueObservable<CharSequence> {
    private final TextView view;

    EditableTextViewTextObservable(TextView view) {
        this.view = view;
    }

    @Override
    protected void subscribeListener(Observer<? super CharSequence> observer) {
        EditableTextViewTextObservable.Listener listener = new EditableTextViewTextObservable.Listener(view, observer);
        observer.onSubscribe(listener);
        view.addTextChangedListener(listener);
    }

    @Override protected CharSequence getInitialValue() {
        return view.getText();
    }

    final static class Listener extends MainThreadDisposable implements TextWatcher {
        private final TextView view;
        private final Observer<? super CharSequence> observer;

        Listener(TextView view, Observer<? super CharSequence> observer) {
            this.view = view;
            this.observer = observer;
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }

        @Override
        public void afterTextChanged(Editable s) {
            if (!isDisposed()) {
                view.removeTextChangedListener(this);
                observer.onNext(s);
                view.addTextChangedListener(this);
            }
        }

        @Override
        protected void onDispose() {
            view.removeTextChangedListener(this);
        }
    }
}