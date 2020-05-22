holder.gamezone_news_title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = mNewsTitleList.get(position);
                Intent mintent = new Intent(mActivity, "your webview load class name");
                mintent.putExtra("keytitle", title);
                startActivity(mintent);

            }
        });