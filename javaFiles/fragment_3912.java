if(!user.getGender().isEmpty()) {
                if(user.getGender().equals("male"))
                    model.put("gender", false);
                else if(user.getGender().equals("female"))
                    model.put("gender", true);
            }