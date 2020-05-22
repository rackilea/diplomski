for (AugmentedFace face : faceList) {

    // Create a face node and add it to the scene.
    AugmentedFaceNode faceNode = new AugmentedFaceNode(face);
    faceNode.setParent(scene);

    // Overlay the 3D assets on the face
    faceNode.setFaceRegionsRenderable(faceRegionsRenderable);

    // Overlay a texture on the face
    faceNode.setFaceMeshTexture(faceMeshTexture);

    // .......
}