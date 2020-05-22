org.json.JSONObject obj = new org.json.JSONObject(org.apache.http.util.EntityUtils.toString(response.getEntity()));
                    if ("Created".equals(obj.getString("status"))) {
                        new AlertDialog.Builder(CreateAccount.this)
                                .setTitle("Account Creation Successful")
                                .setMessage(
                                        "An activation code has been sent to you. Please check your SPAM folder if you do not receive your activation code email")
                                .setNeutralButton("OK", null).show();
                    } else if("Resend".equals(obj.getString("status"))) {
                        new AlertDialog.Builder(CreateAccount.this)
                                .setTitle("Code Resent")
                                .setMessage(
                                        "Your activation code has been resent to your email.\n\nIf you are not receiving your activation code, our email is being blocked. Please email us at 'help@iphone-tracker.net' and we will manually send you a code.")
                                .setNeutralButton("OK", null).show();
                    }