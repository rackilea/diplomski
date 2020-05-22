if (isScrollAtLastPosition){
  showLoading();
  dataList.addAll(getDetails(dataList.size(), 30));
  adapter.notifyDataSetChanged();
  hideLoading();
}