private static boolean check(Context ctx, String value)
{
  if (!Validation.validate(value)) {
    ctx.markError().end();
    return false;
  }
  return true;
}