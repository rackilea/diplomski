MyList l = new MyList();
l.set(0, 0, 1);
l.set(1, 0, 2);
l.set(1, 1, 3);

Log.d("TAG", l.get(0, 0) + " " + l.get(1, 0) + " " + l.get(1, 1));