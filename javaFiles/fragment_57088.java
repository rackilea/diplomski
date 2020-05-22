matrice.setIdentity();

        Main.getMap().getLocalizedUpVector(shootPos, up);
        matrice.m02 = up.x; matrice.m12 = up.y; matrice.m22 = up.z;

        matrice.rotate(pitch, RenderElement.AXIS_PITCH);
        matrice.rotate(yaw, up);

        eye.set(matrice.m02, matrice.m12, matrice.m22);


        if(eye.length() > 0){
            eye.normalise();
        }