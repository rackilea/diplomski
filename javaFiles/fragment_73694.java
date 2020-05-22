ConncurrentMap<BiKey,Stuff> map = new ConcurrentHashMap<BiKey,Stuff>();

class BiKey{
    Key1 k1;
    Key2 k2;
    //let equals return k1.equqls&&k2.equals and implement hashCode accordingly
 }