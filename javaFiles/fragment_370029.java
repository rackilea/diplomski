@Override
    public void restoreState(Hashtable<?, ?> state) 
    {
       Object val = state.get(KEY);
       if( val instanceof Integer ) //performs the null test for us.
       {
          value = val;
       }
    }

    @Override
    public void storeState(Hashtable<Object, Object> state) 
    {
        state.put(KEY, value);
    }