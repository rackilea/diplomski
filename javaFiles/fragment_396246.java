while (j>-1 && isAscending(key.getFirstName(), userList.get(j).getFirstName())){
                User temp = userList.get(j+1);
                System.out.println("TEMP: "+temp.getFirstName());
                userList.add(j+1, userList.get(j));
                userList.add(j, temp);
                j--;
            }