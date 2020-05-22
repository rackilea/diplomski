call.enqueue(new Callback<List<Blog2>>(){
                @Override
                public void onResponse(Call<List<Blog2>> call, Response<List<Blog2>> response) {
                    List<Blog2> mBlogWrapper = response.body();
                    for (int i=0; i<mBlogWrapper.size(); i++) {
                       movies.add(mBlogWrapper.get(i));
                        //Log.d("trace_movies : ",""+ movies);
                    }
                }
            });