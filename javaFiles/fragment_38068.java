DialogPlus dialog = DialogPlus.newDialog(this.context)
        .setContentHolder(viewHolder)
        .setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(DialogPlus dialog, Object item, View view, int position) {
            }
        })
        .setExpanded(true)  // This will enable the expand feature, (similar to android L share dialog)
        .create();