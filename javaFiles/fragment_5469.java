Globals mLuaGlobals1 = JsePlatform.standardGlobals();
Globals mLuaGlobals2 = JsePlatform.standardGlobals();
Globals mLuaGlobals3 = JsePlatform.standardGlobals();

// binding code
mLuaGlobals1.rawset("state", CoerceJavaToLua.coerce(yourJavaObject));
mLuaGlobals2.rawset("state", CoerceJavaToLua.coerce(anotherJavaObject));
// We don't expose anything to mLuaGlobals3 in this example

// Create closures
// We use exact same prototype (script code) for each of them
LuaClosure closure1 = new LuaClosure(prototype, mLuaGlobals1);
LuaClosure closure2 = new LuaClosure(prototype, mLuaGlobals2);
LuaClosure closure3 = new LuaClosure(prototype, mLuaGlobals3);

closure1.call(); // yourJavaObject is exposed through "state" variable
closure2.call(); // anotherJavaObject is exposed through "state" variable
closure3.call(); // "state" variable is absent