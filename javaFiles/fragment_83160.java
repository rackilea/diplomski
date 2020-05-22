List<Component> allComponents; // created in step 2
Component background; // found in step 3 (this is the component with the 0,0 pixel)
Component figureBorder; // found in step 4
List<Component> pixelGroups = new List<Component>(); // list of pixel groups

for each Component c in allComponents:
    if c == background:
        continue;
    for each Pixel pixel in c.pixelList:
        for each Pixel neighbor in pixel.neighbors:
            if neighbor.getComponent() == figureBorder:
                c.isPixelGroup = true;

int numPixelGroups = 0;
for each Component c in allComponents:
    if (c.isPixelGroup)
        numPixelGroups++;