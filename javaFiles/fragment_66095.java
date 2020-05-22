glm::mat4 modelMatrix = matrixStack.back();
glm::mat4 nodeTransform = /*apply your transform here*/
glm::mat4 new = modelMatrix * nodeTransform;
matrixStack.push_back(new);
/*Pass in the new matrix to the shader and call to glDrawArrays or whatever to render your square*/

for (every child) {
    render();
}
matrixStack.pop_back();