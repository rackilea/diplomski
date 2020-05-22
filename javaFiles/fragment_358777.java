Bundle state = new Bundle();
webView.saveState(state);

Intent intent = new Intent(MainActivity.this, Activity2.class);
intent.putExtra("state", state);
intent.putExtra("name", name);