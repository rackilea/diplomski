Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
Bundle b = new Bundle();
b.putInt("key", 1); //Your id
intent.putExtras(b); //Put your id to your next Intent
startActivity(intent);
getActivity().overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_right);