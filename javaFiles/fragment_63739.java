public void updateProgress(float percentage, int position){
    ProgPos = String.valueOf(position);
    Progress = (int) percentage;
    filePaths.get(position).setPercentage(percentage);
    notifyItemChanged(position);
}