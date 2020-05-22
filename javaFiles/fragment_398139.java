// Calculate the local position of the
   // top of screen in the local space
   // of the ground box.
   CCSize scrSize = CCDirector::sharedDirector()->getWinSize();
   b2Vec2 groundWorldPos = b2Vec2((scrSize.width/2)/PTM_RATIO,(scrSize.height)/PTM_RATIO);
   b2Vec2 groundLocalPos = m_pGround->GetLocalPoint(groundWorldPos);

   // Now create the main swinging joint.
   b2RopeJointDef jointDef;
   jointDef.bodyA = m_pGround;
   jointDef.bodyB = body;
   jointDef.localAnchorA = groundLocalPos;
   jointDef.localAnchorB = b2Vec2(0.0f,0.0f);
   jointDef.maxLength = (groundWorldPos-body->GetWorldCenter()).Length();
   jointDef.collideConnected = true;
   world->CreateJoint(&jointDef);