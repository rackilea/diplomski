@Override
public boolean touchDown(int screenX, int screenY, int pointer, int button) {                                       
            testPoint.set(screenX, screenY, 0);
            camera.unproject(testPoint);

            // ask the world which bodies are within the given
            // bounding box around the mouse pointer
            hitBody[pointer] = null;

            world.QueryAABB(callback, testPoint.x - 1.0f, testPoint.y - 1.0f, testPoint.x + 1.0f, testPoint.y + 1.0f);
            hitBody[pointer] = tempBody;

            // if we hit something we create a new mouse joint
            // and attach it to the hit body.
            if (hitBody[pointer] != null) {

                MouseJointDef def = new MouseJointDef();
                def.bodyA = groundBody;
                def.bodyB = hitBody[pointer];
                def.collideConnected = true;                                                 
                def.target.set(hitBody[pointer].getPosition().x, hitBody[pointer].getPosition().y);
                def.maxForce = 3000.0f * hitBody[pointer].getMass();

                mouseJoint[pointer] = (MouseJoint)world.createJoint(def);
                hitBody[pointer].setAwake(true);
            } else {

            }
            tempBody = null;

            return false;