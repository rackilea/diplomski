public int compare(SleepDetails arg0, SleepDetails arg1) {
        int res = arg0.getTime().compareTo(arg1.getTime());
        if (res != 0)
            return res;
        if (arg0.getType() == arg1.getType())
            return 0;
        switch(arg0.getType()) {
          case BEGIN:
            return -1;
          case END:
            return 1;
          default:
            switch(arg1.getType()) {
              case BEGIN:
                return 1;
              case END:
                return -1;
              default:
                return 0;
            }
        }
    }