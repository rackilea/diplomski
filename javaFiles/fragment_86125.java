public interface onItemClickListener {
        void onItemClicked(View view, int position);
    }

public void setOnItemClickListener(onItemClickListener listener) {
        this.onItemClickListener = listener;
    }