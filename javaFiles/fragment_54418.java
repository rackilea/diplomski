//closestCollPt[0] is the line the 'player' will hit next
    var dist = player.position.dist(closestCollPt[0]);

    //the 'player' in my case is a circle, so this indicates collision
    if(dist < player.radius*2)
    {
        //the collision point to the reflection like I mentioned
        //in the text above
        var newDir = closestCollPt[0].vecTo(reflection);

        //I break out their parts, b/c I want to scale the vector
        //doable in one line, but hard to debug
        var newDirX = newDir.x;
        var newDirY = newDir.y;
        var newDirDist = newDir.dist(new Vector(0,0));
        //for whatever reason I was calling the size of a vector
        //'dist' when I wrote this


        var currDirDist = player.direction.dist(new Vector(0,0));

        //give the player the direction we got from Coll->Ref
        //scale it so their speed doesn't change
        player.direction = newDir.scale(currDirDist).scale(1/newDirDist);
    }