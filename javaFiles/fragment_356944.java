Intent intent = new Intent(MainActivity.this,
            SavedPasswordActivity.class);
data.putStringArrayList("SavedPassword",
            addArray);
intent.putExtras(data);
startActivity(intent);