/**
 * Return the {@link FragmentActivity} this fragment is currently associated with.
 * May return {@code null} if the fragment is associated with a {@link Context}
 * instead.
 *
 * @see #requireActivity()
 */
@Nullable
final public FragmentActivity getActivity() {
    return mHost == null ? null : (FragmentActivity) mHost.getActivity();
}