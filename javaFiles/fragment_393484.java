for (int i=0;i<Game.this.mTarget.size();i++) {

        Target t = Game.this.mTarget.get(i);  // Target extends Sprite

        // If the target isn't valid, remove it from the scene and ArrayList
        if (!t.isValid()) { 
            scene.unregisterTouchArea(t);
            scene.detachChild(t);
            Game.this.mTarget.remove(t);
            // Decrease i to keep in sync with the new list
            i--;
        }
    }