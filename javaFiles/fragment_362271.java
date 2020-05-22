if (!(Build.VERSION.SDK_INT < Build.VERSION_CODES.M)) {
                checkCallingPermission();
            } else {
                //call your method to make call
                call();
            }