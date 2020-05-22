if (!fingerprintManager.isHardwareDetected()) {
        msg.setText("Your device doesn't support fingerprint authentication");
    }
    if (ActivityCompat.checkSelfPermission(this, Manifest.permission.USE_FINGERPRINT) != PackageManager.PERMISSION_GRANTED) {
        msg.setText("Please enable the fingerprint permission");
    }
    if (!fingerprintManager.hasEnrolledFingerprints()) {
        msg.setText("No fingerprint configured. Please register at least one fingerprint in your device's Settings");
    }

    if (!keyguardManager.isKeyguardSecure()) {
        msg.setText("Please enable lockscreen security in your device's Settings");
    } else {
        try {
            generateKey();
        } catch (FingerprintException e) {
            e.printStackTrace();
        }

        if (initCipher()) {
            cryptoObject = new FingerprintManager.CryptoObject(cipher);
            helper = new FingerprintHandler(this);
            helper.startAuth(fingerprintManager, cryptoObject);
        }
    }