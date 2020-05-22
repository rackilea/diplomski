public void onSuccess(Void aVoid) {
      Log.d( TAG, "DocumentSnapshot successfully written!" );
      notifyItemRangeChanged(i, downModels.size());
      downModels.remove(i);
      notifyItemRemoved(i);
   }