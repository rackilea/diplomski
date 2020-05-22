@Override
        public void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                //notice the change
                CricScoreApplication app = (CricScoreApplication)getApplication();
                app.setMatchListState(MatchListState.LOADING);

                startService(new Intent(this, MatchUpdateService.class));
                this.receiver = new MatchesReceiver();
                this.filter = new IntentFilter(GenericProperties.INTENT_ML_UPDATE);
                this.matchAdapter = new MatchAdapter(this);
                this.oldState = MatchListState.LOADING;
                RunningInfo.clearSession(getApplicationContext());
        }