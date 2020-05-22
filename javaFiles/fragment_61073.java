layoutDrawer.closeDrawer(linearDrawer);
setLastPosition(posicao);
new Handler().postDelayed(new Runnable() {
        @Override
        public void run() {
            setFragmentList(lastPosition);
        }
    }, 200);