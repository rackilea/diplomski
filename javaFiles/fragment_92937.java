if (Studentinfo.stuID.equals(historyinfo.actOrganizer)){
        switch (Studentinfo.stuSex){
            case "M":
                tvType.setImageResource(R.drawable.circled_user_male);
                break;
            case "F":
                tvType.setImageResource(R.drawable.circled_user_female_skin_type_4);
                break;
        }
    }