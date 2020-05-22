Body mFrictionBody;

mFrictionBody = PhysicsFactory.createBoxBody( mPhysicsWorld, -50, -50, 0, 0, BodyType.StaticBody, FIXTURE_DEF);

FrictionJointDef frictionDef = new FrictionJointDef();
frictionDef.bodyA = mFrictionBody;
frictionDef.bodyB = mMaviParaBody[0];
frictionDef.maxForce = 4.2f;
frictionDef.collideConnected = false;

mFriction[0] = (FrictionJoint) mPhysicsWorld.createJoint( frictionDef );