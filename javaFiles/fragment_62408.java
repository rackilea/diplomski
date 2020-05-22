final class HeavyWeightTooltipEnforcerMac {

  private static final Object LOCK = new Object();
  private static PropertyChangeListener sUIManagerListener;

  private HeavyWeightTooltipEnforcerMac() {
  }

  /**
   * <p>
   *   Tooltips which overlap with the GLCanvas
   *   will be painted behind the heavyweight component when the bounds of the tooltip are contained
   *   in the bounds of the application.
   * </p>
   *
   * <p>
   *   In that case, {@code javax.swing.PopupFactory#MEDIUM_WEIGHT_POPUP} instances are used, and
   *   they suffer from this bug.
   *   Always using {@code javax.swing.PopupFactory#HEAVY_WEIGHT_POPUP} instances fixes the issue.
   * </p>
   *
   * <p>
   *   Note that the bug is only present when not using the Aqua look-and-feel.
   * Aqua uses its own {@code PopupFactory} which does not suffer from this.
   * </p>
   *
   */
  static void install() {
    synchronized (LOCK) {
      if (sUIManagerListener == null && isMacOS()) {
        installCustomPopupFactoryIfNeeded();
        sUIManagerListener = new LookAndFeelChangeListener();
        UIManager.addPropertyChangeListener(sUIManagerListener);
      }
    }
  }

  private static void installCustomPopupFactoryIfNeeded() {
    if (!isAquaLookAndFeel()) {
      PopupFactory.setSharedInstance(new AlwaysUseHeavyWeightPopupsFactory());
    }
  }

  private static final class LookAndFeelChangeListener implements PropertyChangeListener {
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
      String propertyName = evt.getPropertyName();
      if ("lookAndFeel".equals(propertyName)) {
        installCustomPopupFactoryIfNeeded();
      }
    }
  }

  private static class AlwaysUseHeavyWeightPopupsFactory extends PopupFactory {
    private boolean couldEnforceHeavyWeightComponents = true;

    @Override
    public Popup getPopup(Component owner, Component contents, int x, int y) throws IllegalArgumentException {
      enforceHeavyWeightComponents();
      return super.getPopup(owner, contents, x, y);
    }

    private void enforceHeavyWeightComponents() {
      if (!couldEnforceHeavyWeightComponents) {
        return;
      }
      try {
        Method setPopupTypeMethod = PopupFactory.class.getDeclaredMethod("setPopupType", int.class);
        setPopupTypeMethod.setAccessible(true);
        setPopupTypeMethod.invoke(this, 2);
      } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException aE) {
        //If it fails once, it will fail every time. Do not try again
        //Consequence is that tooltips which overlap with a heavyweight component will be painted behind that component iso
        //on top of it
        couldEnforceHeavyWeightComponents = false;
      }
    }
  }
}