if (resp_code.equals("200")) {
     System.out.println("response msg==" + resp_msg);
     Toast.makeText(Registration.this, "response msg==" + resp_msg, Toast.LENGTH_SHORT).show();
} else {
     Toast.makeText(Registration.this,"Donot Match",Toast.LENGTH_SHORT).show();
}