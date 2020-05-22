select = new SelectItem("TEMP" + "SAMPLE");
    select.setMultiple(true);
    select.setMultipleAppearance(MultipleAppearance.PICKLIST);
    select.setTitleAlign(Alignment.LEFT);
    select.setShowFocused(false);
    select.setShowDisabled(false);
    select.setShowErrorStyle(false);

    select_all = new PickerIcon(new Picker("checked.png"),
            new FormItemClickHandler() {

                @Override
                public void onFormItemClick(FormItemIconClickEvent event) {
                    //CODE to set all item to
                }
            });
    select_all.setPrompt("Select all");

    clear_all = new PickerIcon(PickerIcon.CLEAR,
            new FormItemClickHandler() {

                @Override
                public void onFormItemClick(FormItemIconClickEvent event) {

                    select.clearValue();
                }
            });
    clear_all.setPrompt("Clear selection");

    select.setIcons(select_all);