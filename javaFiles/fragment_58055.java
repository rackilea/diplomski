button.setOnClickListener(
            new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    executor = new AsyncTaskExecutor(); 
                    executor.execute(text.getText().toString());
                }
             }
    );