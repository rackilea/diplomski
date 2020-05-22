if(obj.getClass().equals(Integer.class)){
    Integer i = (Integer) obj;
    o.writeInt(i.intValue());
}
else if(obj.getClass().equals(Long.class)){
   Long l = (Long) obj;
   o.writeLong(l.longValue());
}....
else {
   o.writeObject(obj);
}