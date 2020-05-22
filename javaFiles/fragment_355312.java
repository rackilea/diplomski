SwitchCompat[] array = new SwitchCompat[10];

 for (int i = 0; i < 10; i++) 
      {
      SwitchCompat instance;
      String switchId = "iterateHere" + i;
      int resID = getResources().getIdentifier(switchId, "id", getActivity().getPackageName());

      array[i] = instance = v.findViewById(resID);
      instances.add(instance);
      }