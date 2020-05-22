final TaskHolder finalHolder = holder;
        final String name;
        name = t.getMy_task_name();

        holder.chkBox.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (finalHolder.chkBox.isChecked()) {
                    //boolean_value = true;
                    t.setMy_task_is_complete(true);

                    Toast.makeText(v.getContext(), name + "Is Checked -- " + t.getMy_task_is_complete().toString(), Toast.LENGTH_LONG).show();
                } else {
                    //boolean_value = false;
                    t.setMy_task_is_complete(false);
                    Toast.makeText(v.getContext(), name + "Is Unchecked -- " + t.getMy_task_is_complete().toString(), Toast.LENGTH_LONG).show();
                }

            }

        });