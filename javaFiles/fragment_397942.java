public static class AnimatedTableRow<T> extends TableRow<T> {

    private static final PseudoClass PS_NEW = PseudoClass.getPseudoClass("new");
    private static final PseudoClass PS_FLASH = PseudoClass.getPseudoClass("flash");

    private final ObjectExpression<T> recentItem;
    private final InvalidationListener recentlyAddedListener = fObs -> recentItemChanged();

    private final Function<T, BooleanExpression> flashExtractor;
    private final ChangeListener<Boolean> flashListener = (fObs, fOld, fNew) -> flasherChanged(fNew);
    private final Timeline flashTimeline;

    public AnimatedTableRow(ObjectExpression<T> fRecentlyAddedProperty,
            Function<T, BooleanExpression> fFlashExtractor) {
        recentItem = fRecentlyAddedProperty;
        recentItem.addListener(new WeakInvalidationListener(recentlyAddedListener));

        flashExtractor = fFlashExtractor;
        flashTimeline = new Timeline(
                new KeyFrame(Duration.seconds(0.5), e -> pseudoClassStateChanged(PS_FLASH, true)),
                new KeyFrame(Duration.seconds(1.0), e -> pseudoClassStateChanged(PS_FLASH, false)));
        flashTimeline.setCycleCount(Animation.INDEFINITE);
    }

    private void flasherChanged(boolean fNew) {
        if (fNew) {
            flashTimeline.play();
        } else {
            flashTimeline.stop();
            pseudoClassStateChanged(PS_FLASH, false);
        }
    }

    private void recentItemChanged() {
        final T tmpRecentItem = recentItem.get();
        pseudoClassStateChanged(PS_NEW, tmpRecentItem != null && tmpRecentItem == getItem());
    }

    @Override
    protected void updateItem(T item, boolean empty) {
        if (getItem() != null) {
            final BooleanExpression be = flashExtractor.apply(getItem());
            if (be != null) {
                be.removeListener(flashListener);
            }
        }

        super.updateItem(item, empty);

        if (getItem() != null) {
            final BooleanExpression be = flashExtractor.apply(getItem());
            if (be != null) {
                be.addListener(flashListener);
                flasherChanged(be.get());
            }
        }

        recentItemChanged();
    }
}