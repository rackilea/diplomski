private CrimeLab(Context context) {
    mCrimes = new ArrayList<>();
    for (int i = 100; i > 1; i--) {
        Crime crime = new Crime();
        crime.setTitle("Crime :" + i);
        crime.setSovled(i % 2 == 0);
        mCrimes.add(crime);
    }
}