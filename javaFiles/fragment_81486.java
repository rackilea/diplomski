@Override
public void onClick(View v) {
    switch(v.getId()){
        case R.id.b1:
            list.add(someNumber);
            break;
        case R.id.b2:
            list.add(otherNumber);
            break;
    }
    if (list.size() == 2) {
        yourWaitingMethod();
    }
}