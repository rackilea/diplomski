//load
paymentMethodSelectionViewModel.getAllPayments();


//Observers
 paymentMethodSelectionViewModel.paymentMethodList.observe(this,
   Observer { list ->
           // your code
       })