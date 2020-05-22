FancyClass create(params)
{
  FancyClass result;
  try (FancyClassParams params = new FancyClassParams(params))
  {
    FancyClassParams.init();
    result = new FancyClass(FancyClassParams);
    result.init(FancyClassParams);
    FancyClassParams.success = true;
  }
}