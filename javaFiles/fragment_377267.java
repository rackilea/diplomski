this.grantUriPermission(this.getPackageName(), data.getData(), Intent.FLAG_GRANT_READ_URI_PERMISSION);
        final int takeFlags = data.getFlags()
                & (Intent.FLAG_GRANT_READ_URI_PERMISSION
                | Intent.FLAG_GRANT_WRITE_URI_PERMISSION);            // Check for the freshest data.
        //noinspection WrongConstant
        this.getContentResolver().takePersistableUriPermission(data.getData(), takeFlags);