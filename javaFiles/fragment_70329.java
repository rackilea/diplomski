if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.READ_PHONE_STATE)
                    != PackageManager.PERMISSION_GRANTED) {
                requestContactsPermissions1();
            } else {
                setTextVisablity(false);
                checkSimCard();
            }