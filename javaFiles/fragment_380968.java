$> cat foo.scala
object MonthSelection extends Enumeration {
    type MonthSelection = Value

    val LastMonth, ThisMonth, NextMonth, CustomMonth = Value
}

$> scalac -d bin foo.scala
$> ls bin
MonthSelection$.class  MonthSelection.class
$> javap bin/MonthSelection
Compiled from "foo.scala"
public final class MonthSelection extends java.lang.Object{
    public static final scala.Enumeration$Value CustomMonth();
    public static final scala.Enumeration$Value NextMonth();
    public static final scala.Enumeration$Value ThisMonth();
    public static final scala.Enumeration$Value LastMonth();
    public static final scala.Enumeration$ValueSet$ ValueSet();
    public static final scala.Enumeration$Value withName(java.lang.String);
    public static final scala.Enumeration$Value apply(int);
    public static final int maxId();
    public static final scala.Enumeration$ValueSet values();
    public static final java.lang.String toString();
}