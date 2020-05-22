weightIce = ...;
weightStone = ...;
weightGrass = 1.0 - weightIce - weightStone;
color = texture2D(ice_layer_tex, texcoord) * weightIce +
        texture2D(stone_layer_tex, texcoord) * weightStone +
        texture2D(grass_layer_tex, texcoord) * weightGrass;