@Override
public void onBindViewHolder(ArticleViewHolder ArticleViewHolder, int position) {
ArticleViewHolder.articleTitle.setText(articles.get(position).getArticleTitle());
ArticleViewHolder.articleLink.setText(articles.get(position).getArticleLink());
ArticleViewHolder.articleBody.setText(articles.get(position).getArticleBody());
ArticleViewHolder.articlePhotoID.setImageResource(articles.get(position).getArticlePhotoId());
}