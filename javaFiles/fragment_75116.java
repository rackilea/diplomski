@Override
public boolean onTextContextMenuItem(int id) {
    if (id == android.R.id.cut) {
        return true;
    }

    return super.onTextContextMenuItem(id);
}