Handler handler = new Handler();
try {
    for (int a = 1; a <= 3; a++) {
        for (int i = 0; i < data.length(); i++) {

            if (data.charAt(i) == '1') {
                handler.postDelayed(new Runnable() {
                    @Override public void run() {
                        camera.setParameters(parametersOn);
                        camera.startPreview();
                    }
                }, i * 100);
            } else {
               handler.postDelayed(new Runnable() {
                    @Override public void run() {
                        camera.setParameters(parametersOff);
                        camera.startPreview();
                    }
                }, i * 100);
            }
        }
    }
} catch (Exception e) {

}