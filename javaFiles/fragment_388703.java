if (choosenDate.get(Calendar.DAY_OF_WEEK) == 
                    Calendar.SUNDAY || 
                    now.compareTo(choosenDate) < 0) {
                    dateTextView.setTextColor(
                        Color.parseColor("#ff0000")
                    );
                    ((Button) dialog.getButton(
                    AlertDialog.BUTTON_POSITIVE))
                        .setEnabled(false);
                } else {
                    dateTextView.setTextColor(
                        Color.parseColor("#000000")
                    );
                    ((Button) dialog.getButton(
                    AlertDialog.BUTTON_POSITIVE))
                        .setEnabled(true);
                }