//please notice, mCallback.onVerificationCompleted will automatically called 
//if verification code already send to your phone 
//(Maybe not called in some case)
mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

    @Override
    public void onVerificationCompleted(PhoneAuthCredential credential) {
        linkPhoneAuthToCurrentUser(credential);
    }

    @Override
    public void onVerificationFailed(FirebaseException e) {
        //show error
    }
    @Override
    public void onCodeSent(String verificationId,
                           PhoneAuthProvider.ForceResendingToken token) {
        //save id and token in case you need to resend verification code
    }
};

//call this to send verification code
//parameter include country code
private void sendVerificationCode(String phonenumber) {
    PhoneAuthProvider.getInstance().verifyPhoneNumber(
            phonenumber,        // Phone number to verify
            60,                 // Timeout duration
            TimeUnit.SECONDS,   // Unit of timeout
            this,               // Activity (for callback binding)
            mCallbacks);        // OnVerificationStateChangedCallbacks
}

//link auth with credential
private void linkPhoneAuthToCurrentUser(PhoneAuthCredential credential) {
    FirebaseAuth.getInstance().getCurrentUser().linkWithCredential(credential)
        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    //link auth success update ui
                } else {
                    //link auth failed update ui
                }
            }
        });
}
@Override
protected void onCreate(Bundle savedInstanceState) {
   super.onCreate(savedInstanceState);
   setContentView(R.layout.user_phone_verify);

   //init view 

   //get phone number
   String phoneNumb = "Add Your Phone Number Here"
   sendVerificationCode(phoneNumb)

   //if mCallback not called, 
   //use this button to sign in with manual input verification code
   btnSignIn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //get verification id from mCallback.onCodeSent
            //get verificationCode manually from edittext 
            PhoneAuthCredential credential = PhoneAuthProvider.getCredential(verificationId, verificationCode);
            linkPhoneAuthToCurrentUser(credential);
        }
    });
}