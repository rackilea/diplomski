public void notify()
      {
        for (int i=0;i < observers.size();i++)
        {
          Observer ob = (Observer)observers.get(i);
          ob.update(newValue);
        }
      }