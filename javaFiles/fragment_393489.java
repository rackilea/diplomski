LiveData<Data> getNews() {

final MutableLiveData<Data> data = new MutableLiveData<>();

setNews( new MyCallback(){

 Void onSuccess(Data data){

data.setValue(data); // for success live data get call back
} 
void onError(){
 data.setValue(null); // for error case can pass null or empty list
}
});

return data;
}