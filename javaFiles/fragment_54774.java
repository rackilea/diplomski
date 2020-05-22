((SendToMailTypeViewHolder) holder).switchSendMailReport.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(CompoundButton buttonView, 
                         boolean isChecked) {
                            if (isChecked) {
                            onAdapterResult.onAdapterResult(isChecked); \\ here
                            } else {

                            }
                        }
                    });