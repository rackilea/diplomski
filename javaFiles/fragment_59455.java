local sceneGroup = self.view
local bg = display.newImage ("bg.png")

-- Initialize the scene here.
-- Example: add display objects to "sceneGroup", add touch listeners, etc.
-- Our ScrollView listener
local function scrollListener( event )
    local phase = event.phase
    local direction = event.direction

    if "began" == phase then
        --print( "Began" )
    elseif "moved" == phase then
        --print( "Moved" )
    elseif "ended" == phase then
        --print( "Ended" )
    end

    -- If the scrollView has reached it's scroll limit
    if event.limitReached then
        if "up" == direction then
            print( "Reached Top Limit" )
        elseif "down" == direction then
            print( "Reached Bottom Limit" )
        elseif "left" == direction then
            print( "Reached Left Limit" )
        elseif "right" == direction then
            print( "Reached Right Limit" )
        end
    end

    return true
end

-- Create a ScrollView
local scrollView = widget.newScrollView
{
    left = 0,
    top = 0,
    width = display.contentWidth,
    height = display.contentHeight,
    bottomPadding = 50,
    id = "onBottom",
    horizontalScrollDisabled = true ,
    verticalScrollDisabled = false ,
    hideBackground = true, 
    listener = scrollListener,
}


local worlds = display.newImage ("images (2).jpg")
worlds.x = 100
worlds.y = 100
scrollView:insert( worlds)

local worlds1 = display.newImage ("images (2).jpg")
worlds1.x = 100
worlds1.y = 800
scrollView:insert( worlds1)


local worlds2 = display.newImage ("images (2).jpg")
worlds2.x = 100
worlds2.y = 500
scrollView:insert( worlds2)


local worlds3 = display.newImage ("images (2).jpg")
worlds3.x = 100
worlds3.y = 1000
scrollView:insert( worlds3)


local worlds4 = display.newImage ("images (2).jpg")
worlds4.x = 100
worlds4.y = 2000
scrollView:insert( worlds4)
    sceneGroup:insert(scrollView)