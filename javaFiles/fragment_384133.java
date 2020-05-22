newFragment = new SweetA();
transaction.addToBackStack(null);
transaction.hide(this);
transaction.add(R.id.containerID, newFragment);
transaction.commit();
break;