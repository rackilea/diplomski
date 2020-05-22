@Override
public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()){
        case R.id.account_id:
            Intent account =new Intent(MainpanelActivity.this,AccountActivity.class);
            startActivity(account);
            break;
        case R.id.logout_id:
            Intent login = new Intent(MainpanelActivity.this, LoginActivity.class);
            login.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(login);
            break;
        default:
            return super.onOptionsItemSelected(item);
    }
}