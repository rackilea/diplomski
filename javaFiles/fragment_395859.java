String myPhone = getCallName.substring(16, getCallName.length() - 4);

            if (!myPhone.matches("^[\\d]{1,}$")) {
                myPhone = context.getString(R.string.withheld_number);
            } else if (listDir.get(i).getUserNameFromContact() != myPhone) {
                myPhone = listDir.get(i).getUserNameFromContact();
            }