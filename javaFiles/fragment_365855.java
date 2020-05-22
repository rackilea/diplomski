public class AccessibilityService extends android.accessibilityservice.AccessibilityService {
    private final PublishSubject<AccessibilityEvent> accessibilityEventPublishSubject = PublishSubject.create();

    public AccessibilityServiceControllerImpl() {
        accessibilityEventPublishSubject
                .debounce(400, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<AccessibilityEvent>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(AccessibilityEvent accessibilityEvent) {
                        Log.d(TAG, accessibilityEvent.toString());
                    }
                });
    }

    @Override
    public void evaluateEvent(final AccessibilityEvent accessibilityEvent) {
        int type = accessibilityEvent.getEventType();
        switch (type) {
            case AccessibilityEvent.TYPE_VIEW_TEXT_CHANGED:
                Timber.d("Event received in controller: " + accessibilityEvent.toString());
                accessibilityEventPublishSubject.onNext(accessibilityEvent);
                break;
            default:
                break;
        }
    }
}