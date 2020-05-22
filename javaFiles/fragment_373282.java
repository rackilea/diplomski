feedbackbutton.setOnClickListener(new OnClickListener(){  

            @Override  
            public void onClick(View arg0) {  
                //Getting the rating and displaying it on the toast  
                String rating=String.valueOf(rating.getRating());  
                Toast.makeText(getApplicationContext(), rating, Toast.LENGTH_LONG).show();  
            }  

        });