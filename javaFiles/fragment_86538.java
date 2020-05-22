@Override
public boolean onOptionsItemSelected(MenuItem item) {
    boolean rtn = false;
    switch (item.getItemId()) {
        case R.id.action_create: //run NoteActivity in new note mode
            startActivity(new Intent(this, NoteActivity.class));
            rtn = true;
            break;

        case R.id.action_settings:
            //TODO show settings activity
            rtn = true;
            break;
        default:
            rtn = super.onOptionsItemSelected(item);
    }

    return rtn;
}