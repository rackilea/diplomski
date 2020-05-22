for(int i=0;i<name.size() && i < comment.size();i++) {
     feedback f = new feedback();
     f.name = name.get(i);
     f.comment = comment.get(i);
     fb.add(f);
}