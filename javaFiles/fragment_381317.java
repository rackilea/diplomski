endButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(handler != null)
                handler.removeCallbacksAndMessages(null);
            }
        });