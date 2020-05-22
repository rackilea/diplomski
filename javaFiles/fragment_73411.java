call.enqueue(new Callback<APIResponse>() {
        @Override
        public void onResponse(Call<APIResponse> call, Response<APIResponse> response) {
            if(!response.isSuccessful()){
                textViewResult.setText("Code : " + response.code());
                return;
            }

            List<User> users = response.body().getUsers();

            for(User user : users){
                String content = "";
                content += "ID: " + user.getId() + '\n';
                content += "FirstName: " + user.getFirstname() + '\n';
                content += "Name: " + user.getName() + '\n';
                content += "Picture: " + user.getPicture() + '\n';

                textViewResult.append(content);
            }
        }

        @Override
        public void onFailure(Call<List<User>> call, Throwable t) {
            textViewResult.setText(t.getMessage());
        }
    });