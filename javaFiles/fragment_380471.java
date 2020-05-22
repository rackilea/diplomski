for(String i: new ArrayList<>(list_old)) {
                for(String j: new ArrayList<>(list_new)) {
                    if (!i.equals(j)) {
                        list_old.add(i);
                        break;
                    }
                }
            }