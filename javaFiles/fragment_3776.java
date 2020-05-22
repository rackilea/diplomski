@Override
public boolean onOptionsItemSelected(MenuItem item) {

    if (item.getItemId() == android.R.id.home) {
        finish();
        overridePendingTransition(R.animator.anim_left, R.animator.anim_right);
        return true;
    }
    return false;
}