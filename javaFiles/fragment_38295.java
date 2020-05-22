public void onItemClick(DocumentSnapshot documentSnapshot, int position) {
            Book book = documentSnapshot.toObject(Book.class);
            String id = documentSnapshot.getId();
            String path = documentSnapshot.getReference().getPath();
            Toast.makeText(AdminReadActivity.this,
                    "Position: " + position + " ID: " + id, Toast.LENGTH_SHORT).show();

            String chapterName = adapter.getItem(position).getChapterName();
            String chapterInfo = adapter.getItem(position).getChapterInfo();
            Integer chapterNumber = adapter.getItem(position).getChapterNumber();

            Intent intent = new Intent(AdminReadActivity.this, AdminUpdateActivity.class);

            intent.putExtra("mChapterName", chapterName);
            intent.putExtra("mChapterInfo", chapterInfo);
            intent.putExtra("mChapterNumber", chapterNumber);
            intent.putExtra("mId", id); // Add this line

            startActivity(intent);