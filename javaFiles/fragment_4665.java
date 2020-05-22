SELECT ?input ?string ?percent WHERE
{
   VALUES ?string { "London" "Londn" "London Fog" "Lando" "Land Ho!"
                    "concatenate" "catnap" "hat" "cat" "chat" "chart" "port" "part" }

   VALUES ?input  { "cat" "londn" }

   ?input <urn:ex:fn#matches> (?string ?percent) .
}
ORDER BY DESC(?percent)