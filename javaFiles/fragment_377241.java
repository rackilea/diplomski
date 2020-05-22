library(xml2)
library(purrr)

# need to write code to do the unzipping and also to work with all the
# sheets from the xlsx file.

sheet <- read_xml("~/dir/wb/xl/worksheets/sheet1.xml")
ns <- xml_ns_rename(xml_ns(sheet), d1 = "x")
xml_find_all(sheet, ".//x:row", ns) %>% 
  map_df(function(row) {
    xml_find_all(row, ".//x:c", ns) %>% 
      map_df(function(col) {
        xml_find_all(col, ".//x:f", ns) %>% 
          xml_text() -> f
        if (length(f) > 0) {
          data_frame(cell=xml_attr(col, "r"), f=f)
        } else {
          NULL
        }
      })
  })
## # A tibble: 2 × 2
##    cell                     f
##   <chr>                 <chr>
## 1    B2            SUM(A1:A3)
## 2    C2 SUM(A1:A3)*SUM(A1:A3)