VideoView view = (VideoView) this.findViewById(R.id.vv);

        view.setVideoPath(path);
        view.setMediaController(new MediaController(this));
        view.requestFocus();
        view.start();