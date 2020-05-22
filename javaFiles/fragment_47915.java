class PaymentMethodSelectionViewModel: ViewModel() {

    //Data
    var paymentMethodList =  MutableLiveData<List<PaymentMethodModel>>()

    fun getAllPayments(){

        val retrofit = Retrofit.Builder()
            .baseUrl(SERVICE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(PaymentClient::class.java)
        val jsonCall = service.getListOfPaymentMethods()

        jsonCall.enqueue(object : Callback<List<PaymentMethodModel>> {
            override fun onResponse(call: Call<List<PaymentMethodModel>>, response: Response<List<PaymentMethodModel>>) {

                var data: List<PaymentMethodModel>  = (response.body() as ArrayList<PaymentMethodModel>?)!!

               paymentMethodList.value=data


            }

            override fun onFailure(call: Call<List<PaymentMethodModel>>, t: Throwable) {
                //TODO
            }
        })
    }



}