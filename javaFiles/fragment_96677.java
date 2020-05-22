LinearLayout listItem;
TextView tvGithubUrl;


tvGithubUrl = (TextView) findViewById(R.id.github_url)
listItem = (LinearLayout) findViewById(R.id.list_item)

listItem.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //Get the github_url text here
        tvGithubUrl.getText().toString();
        }
    });