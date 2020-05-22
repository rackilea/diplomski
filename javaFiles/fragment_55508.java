protected void onPreExecute(Void result) {
product.setFetching(true)
}


protected void onPostExecute(Void result) {
product.setFetching(false)
}