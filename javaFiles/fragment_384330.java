@Override
        public void onClick(View view) {
            Log.d(TAG, "onClick " + getAdapterPosition());
            CustomBean bean =list.get(getAdapterPosition())
             String id = bean.getAcutionId()
              // now intent it
         }