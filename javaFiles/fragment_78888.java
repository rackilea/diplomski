mPathFinderMap = new IPathFinderMap<TMXLayer>(){

            private boolean mCollide;

            @Override
            public boolean isBlocked(final int pX, final int pY, final TMXLayer pTMXLayer) {
                /*
                 * This is where collisions happen and are detected 
                 */
                mCollide = false;
                //Null check. Used since not all tiles have properties
                if(pTMXLayer.getTMXTile(pX, pY).getTMXTileProperties(mTiledMap) != null){
                    //Get tiles with collision property
                    if(pTMXLayer.getTMXTile(pX, pY).getTMXTileProperties(mTiledMap).containsTMXProperty("COLLISION", "true")) 
                        mCollide = true;                                        
                }   

                if(mTMXmapLoader.getCollideTiles().contains(pTMXLayer.getTMXTile(pX, pY)))
                    mCollide = true;

                return mCollide;
            }

    };

/*
 * This method moves the sprite to the designated location
 */
public void walkTo(TMXTile pFinalPosition) {
    if(mHasFinishedPath){
        mHasFinishedPath = false;//This prevents overlapping paths when the user double clicks. Used to prevent stutter
        //Player coordinates
        final float[] lPlayerCordinates = mPlayerSprite.convertLocalToSceneCoordinates(mPlayerSprite.getWidth()/2, mPlayerSprite.getHeight()/2);
        // Get the tile the center of the player are currently waking on. 
        TMXTile lPlayerPosition = SceneManager.mWorldScene.getTouchLayer().getTMXTileAt(lPlayerCordinates[Constants.VERTEX_INDEX_X], lPlayerCordinates[Constants.VERTEX_INDEX_Y]);
        mFinalPosition = pFinalPosition;

        // Sets the A* path from the player location to the touched location.
        if(mPathFinderMap.isBlocked(pFinalPosition.getTileColumn(), pFinalPosition.getTileRow(), SceneManager.mWorldScene.getTouchLayer())){    
            pFinalPosition = getNextTile(lPlayerPosition, pFinalPosition);
        }

        // These are the parameters used to determine the 
        int lFromCol = lPlayerPosition.getTileColumn(); int lFromRow = lPlayerPosition.getTileRow();
        int lToCol = pFinalPosition.getTileColumn();    int lToRow = pFinalPosition.getTileRow();
        boolean lAllowDiagonal = false;
        // Find the path. This needs to be refreshed
        AStarPath = mAStarPathFinder.findPath(MAX_SEARCH_DEPTH, mPathFinderMap, 0, 0, mTiledMap.getTileColumns() - 1, mTiledMap.getTileRows() - 1, SceneManager.mWorldScene.getTouchLayer(), 
                lFromCol, lFromRow, lToCol, lToRow, lAllowDiagonal, mHeuristic, mCostCallback);

        //Log.i("AstarPath", "AStarPath  " + AStarPath);
        //Only loads the path if the AStarPath is not null
        Path lPlayerPath = loadPathFound();
        //Log.i("AstarPath", "lPlayerPath  " + lPlayerPath);
        if(lPlayerPath != null)
            moveSprite(lPlayerPath);//Moves the sprite along the path
        else
            mHasFinishedPath = true;//If the path is null the player has not moved. Set the flag to true allows input to effect the sprite
    }else{
        //Update parameters
        mFinalPosition = pFinalPosition;
        mWaypointIndex = 0;
    }
}

/*
 * Updates the path
 */
public void updatePath(TMXTile pFinalPosition) {    
    //Player coordinates
    final float[] lPlayerCordinates = mPlayerSprite.convertLocalToSceneCoordinates(mPlayerSprite.getWidth()/2, mPlayerSprite.getHeight()/2);
    // Get the tile the feet of the player are currently waking on. 
    TMXTile lPlayerPosition = SceneManager.mWorldScene.getTouchLayer().getTMXTileAt(lPlayerCordinates[Constants.VERTEX_INDEX_X], lPlayerCordinates[Constants.VERTEX_INDEX_Y]);

    // Sets the A* path from the player location to the touched location.
    if(mPathFinderMap.isBlocked(pFinalPosition.getTileColumn(), pFinalPosition.getTileRow(), SceneManager.mWorldScene.getTouchLayer())){    
        pFinalPosition = getNextTile(lPlayerPosition, pFinalPosition);
    }

    // Determine the tile locations
    int FromCol = lPlayerPosition.getTileColumn();
    int FromRow = lPlayerPosition.getTileRow();
    int ToCol = pFinalPosition.getTileColumn();
    int ToRow = pFinalPosition.getTileRow();
    // Find the path. This needs to be refreshed
    AStarPath = mAStarPathFinder.findPath(MAX_SEARCH_DEPTH, mPathFinderMap, 0, 0, mTiledMap.getTileColumns()-1, mTiledMap.getTileRows()-1, SceneManager.mWorldScene.getTouchLayer(), 
            FromCol, FromRow, ToCol, ToRow, false, mHeuristic, mCostCallback);

    //Loads the path with the astar specifications
    Path lPlayerPath = loadPathFound();
    //Moves the sprite along the path
    if(lPlayerPath != null){
        moveSprite(lPlayerPath);
    }else{
        //If the path is still null after the path manipulation then the path is finished
        mHasFinishedPath = true;
        mWaypointIndex = 0;
        //mPlayerSprite.stopAnimation();
        //AStarPath = null;
    }
}