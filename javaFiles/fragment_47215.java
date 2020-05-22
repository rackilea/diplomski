public Scene soot_Scene() {
    if(this.instance_soot_Scene == null) {
        synchronized(this) {
            if(this.instance_soot_Scene == null) {
                this.instance_soot_Scene = new Scene(this.g);
            }
        }
    }

    return this.instance_soot_Scene;
}