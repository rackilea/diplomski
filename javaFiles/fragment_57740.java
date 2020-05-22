areaRequest.countByCurrentInstitution().fire(new Receiver<Long>() {
@Override
public void onSuccess(Long response) {
// Here I pass the value from the first request
    anotherRequest.anotherFunction(response).fire(new Receiver<Long>(){
        @Override
        public void onSuccess(Long new_response){ // Long again it could be anything it depends of your function
            doWhateverYouWant(new_response)
        }
    });
}