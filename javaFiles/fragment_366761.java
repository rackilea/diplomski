// pass some temp storage down to the native code. 1024 is made up,
// but should be large enough to avoid too many small calls back
// into is.read(...) This number is not related to the value passed
// to mark(...) above.
byte [] tempStorage = null;
if (opts != null) tempStorage = opts.inTempStorage;
if (tempStorage == null) tempStorage = new byte[16 * 1024];