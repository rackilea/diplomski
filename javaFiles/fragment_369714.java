public final class FragmentUtils {
    private FragmentUtils() {
    }
    public static void add(FragmentActivity fragmentActivity, int layoutId, Fragment fragment) {
        if (isContextInvalid(fragmentActivity)) {
           return
        }
        FragmentTransaction fragmentTransaction = fragmentActivity.getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(layoutId, fragment);
        fragmentTransaction.commit();
    }

    public static void replace(FragmentActivity fragmentActivity, int layoutId, Fragment fragment) {
        if (isContextInvalid(fragmentActivity)) {
           return
        }
       // TODO: you do this one ;)

    }

    public static void remove(FragmentActivity fragmentActivity, Fragment fragment) {
        if (isContextInvalid(fragmentActivity)) {
           return
        }
        // TODO: you do this one ;)
        if (fragment.isAdded()) {
            …
        }
    }

    public static void show(FragmentActivity fragmentActivity, Fragment fragment) {
        // TODO: you do this one ;)
        if (fragment.isAdded()) {
            …
        }
    }

    public static void hide(FragmentActivity fragmentActivity, Fragment fragment) {
        // TODO: you do this one ;)
        if (fragment.isAdded()) {
            …
        }
    }
    public boolean isContextInvalid(final Context context) {
        if (context == null || context.isFinishing()) {
            return true;
        }
        return false;
    }
}