IntentIntegrator scanIntegrator = new IntentIntegrator(MainActivity.this);
 scanIntegrator.setPrompt("Scan a Barcode");
 scanIntegrator.setBeepEnabled(true); 
 scanIntegrator.setOrientationLocked(true);
 scanIntegrator.setBarcodeImageEnabled(true);
 scanIntegrator.initiateScan();