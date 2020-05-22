public void compare(ArrayList list_old, ArrayList list_new) {
        try {
            Iterator<User> iterator_old;
            Iterator<User> iterator_new = list_new.iterator();

            //Check New User Is Added
            while (iterator_new.hasNext()) {
                Log.i("Test", "inside!");
                User user_new = iterator_new.next();
                boolean NEW = true;
                iterator_old = list_old.iterator();
                while (iterator_old.hasNext() && NEW) {
                    User user_old = iterator_old.next();
                    if (user_new.getUsername().equals(user_old.getUsername())) {
                        NEW = false;
                    }
                }
                if (NEW) {
                    generateNotification(getApplicationContext(), user_new.getUsername() + " has been added.");
                }
            }
            //initialize again
            iterator_old = list_old.iterator();
            //Check User Is Removed
            while (iterator_old.hasNext()) {
                Log.i("Test", "inside");
                User user_old = iterator_old.next();
                boolean NEW = true;
                 iterator_new = list_new.iterator();    
                while (iterator_new.hasNext() && NEW) {
                    User user_new = iterator_new.next();
                    if (user_old.getUsername().equals(user_new.getUsername())) {
                        NEW = false;
                    }
                }
                if (NEW) {
                    generateNotification(getApplicationContext(), user_old.getUsername() + " has been removed.");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }