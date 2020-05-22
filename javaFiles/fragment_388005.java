InputStream stream = (InputStream)this.getClass().getResourceAsStream("/preview.mp3");
p = Manager.createPlayer(stream, "audio/mpeg");
p.realize();
p.prefetch();
p.setLoopCount(-1);
VolumeControl volume = (VolumeControl) p.getControl("VolumeControl");
volume.setLevel(1);
p.start();