RecurrenceRule rule = new RecurrenceRule("FREQ=YEARLY;BYMONTHDAY=23;BYMONTH=5");

DateTime start = new DateTime(1982, 4 /* 0-based month numbers! */,23);

RecurrenceRuleIterator it = rule.iterator(start);

int maxInstances = 100; // limit instances for rules that recur forever

while (it.hasNext() && (!rule.isInfinite() || maxInstances-- > 0))
{
    DateTime nextInstance = it.nextDateTime();
    // do something with nextInstance
}