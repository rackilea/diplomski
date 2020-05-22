import lotus.domino.local.Name;
...
      Vector<Name> groups = s.getUserGroupNameList();
      System.out.println("User groups are " + groups);
      Boolean n = false;
      for (Name group : groups) {
          if (group.getCommon().equals("Notes_Admin")) {
              n = true;
              break;
          }
      }
      System.out.println("n = " + n);