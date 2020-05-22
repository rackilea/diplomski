Thread timer = new Thread() {
                @Override
                public void run() {
//do something
     getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getActivity(),
                            "Token Generated", Toast.LENGTH_SHORT).show();
                        }
                    });
       }
            };
            timer.start();