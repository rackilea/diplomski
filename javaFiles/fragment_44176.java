int count = 0;
                int size = theContactsList.size();
                for (int i = 0; i < size; i++) {
                    if (theContactsList.get(i).isSelected) {
                        count++;
                    }
                }
                if(count==0) {
                    Toast.makeText(context_type, "All unchecked!" , Toast.LENGTH_SHORT).show();
                }