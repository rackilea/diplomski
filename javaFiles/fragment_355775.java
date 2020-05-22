Call<PostR> call = jsonPlaceHolderApi.createPost(fields);
    call.enqueue(new Callback<PostR>() {
        @Override
        public void onResponse(Call<PostR> call, Response<PostR> response) {    
            if (!response.isSuccessful()) {
                textViewResult.setText("Code: " + response.code());
                return;
            }    
            PostR postRResponse = response.body();
            Post postResponse = postRResponse.getData();
            if(postResponse!=null) {
                String content = "";
                content += "Code: " + response.code() + "\n";
                content += "ID: " + postResponse.getId() + "\n";    
                content += "Name : " + postResponse.getName() + "\n";
                content += "Salary : " + postResponse.getSalary() + "\n";
                content += "Age :" + postResponse.getAge() + "\n\n";
            }
           // textViewResult2.setText(content);
            Toast.makeText(MainActivity.this, "Ans::"+content, Toast.LENGTH_LONG).show();
        }

        @Override
        public void onFailure(Call<PostR> call, Throwable t) {    
            //textViewResult.setText(t.getMessage());
            Toast.makeText(MainActivity.this, "Failed "+t.getMessage(), Toast.LENGTH_LONG).show();
        }