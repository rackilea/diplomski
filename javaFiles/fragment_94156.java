local mt = getmetatable(userData)
mt.__index = {
    newMethod = function()
        print('It works!')
    end
}