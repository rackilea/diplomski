import static com.example.Factory.*;

union(
  query(is("tall"), 
        capableOf("basketball"), 
        name("michael").or(name("dennis"))
  ),
  query(color("silver"),
        a("spoon"),
        is("bent"),
        is("shiny")
  )
);