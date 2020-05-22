class DiscardOrDrawTask extends AsyncTask<Void, Void, Game.PileDecision> {

        @Override
        protected Game.PileDecision doInBackground(Void... params) {
            final Game.PileDecision pickFrom = tryDiscardOrDrawPile(isFinalTurn, deck.discardPile.peekNext(), deck.drawPile.peekNext());
            return pickFrom;
        }

        @Override
        protected void onPreExecute() {
            myActivity.showSpinner(true);
        }

        @Override
        protected void onPostExecute(final Game.PileDecision pickFrom) {
            myActivity.showSpinner(false);
            myActivity.animateComputerPickUpAndDiscard(playerMiniHandLayout, pickFrom);
        }
    }
    DiscardOrDrawTask discardOrDrawTask= new DiscardOrDrawTask();
    discardOrDrawTask.execute();