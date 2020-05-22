delete_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validate(v)) {
                    deleteProduct();
                }
            }
        });