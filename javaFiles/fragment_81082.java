uses
    ..., DateUtils;

procedure TMyJavaObject.SetDateStart(const DateStart: TDateTime);
var
  DateValue: Int64; // a Java 'long' is a 64-bit type
  DateClass: JClass;
  DateObj: JObject;
  method : JMethodID;
begin
  // DateTimeToUnix() returns a value in seconds,
  // but the java.util.Date(long) constructor expects
  // a value in milliseconds instead...
  DateValue := DateTimeToUnix(DateStart) * 1000;

  // create a java.util.Date object instance, passing the
  // converted TDateTime value as a 'long' to its constructor...
  DateClass := JNIEnv.FindClass('java/util/Date');
  method := JNIEnv.GetMethodID(DateClass, '<init>', '(J)V');
  DateObj := JNIEnv.NewObject(DateClass, method, [DateValue]);

  // pass the java.util.Date object to the desired object method...
  method := getMethod(self.clazz, 'setDateStart', '(Ljava/util/Date;)V');
  JNIEnv.CallVoidMethod(self.javaObject, method, [DateObj]);
end;