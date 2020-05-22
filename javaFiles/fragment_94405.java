if (android.os.Build.VERSION.SDK_INT == 25) {
                ToastCompat.makeText(context, message, Toast.LENGTH_SHORT)
                        .setBadTokenListener(toast -> {
                            Log.e("failed toast", message);
                        }).show();
            } else {
                Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
            }