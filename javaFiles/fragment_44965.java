A aObject = new A();

aToBMapper.updateAFromB(bObject, aObject);
aToCMapper.updateAFromC(cObject, aObject);

// now aObject should contain the cumulated data from b and c