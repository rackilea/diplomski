view.postDelayed(new Runnable() {
                @Override
                public void run() {
                    ((MainActivity)getActivity()).scrollToFrag(frag_number+"");
                }
            }, 200);