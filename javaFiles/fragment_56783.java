holder.textView.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
               if(adapterCallback  != null){
                  adapterCallback.onMethodCallback();  
              }
          }
      });