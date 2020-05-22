final AndroidGame agame = (AndroidGame) game;

    agame.runOnUiThread(new Runnable() {

        @Override
        public void run() {
            View currentView = agame.findViewById(R.id.gameLayout);
            ViewGroup parent = (ViewGroup) currentView.getParent();
            currentView = agame.getLayoutInflater().inflate(R.layout.highscorescontent, parent, false);
            parent.addView(currentView);
        }
    });