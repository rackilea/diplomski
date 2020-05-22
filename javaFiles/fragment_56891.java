Invoice inv = new Invoice();
inv.add(a1);
inv.add(a2);
inv.add(a3);
ArrayList<Article> temp = inv.getArticleList();
for (int i=0;i<temp.size();i++){
    System.out.println(temp.get(i).getCod());
}