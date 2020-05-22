private string GetName(Thing thing)
{
    return thing.Name;
}

...

List<String> nameList1 = thingList.Select(GetName).ToList();