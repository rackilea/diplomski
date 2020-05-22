StringBuffer stringBuffer = new StringBuffer();
for(MovieModel.Cast cast : movieModelList.get(position).getCastList()){
    if (stringBuffer.length() != 0) {
        stringBuffer.append(",");
    }
    stringBuffer.append(cast.getName());
}