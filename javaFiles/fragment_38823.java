ui <- (fluidPage(
  tags$style(type='text/css', ".selectize-dropdown-content {max-height: 1000px !important; }"), 
  sidebarLayout(
    sidebarPanel(
      selectInput("userInput","Select User", c(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21),
                  selected=1),
      selectInput("LongInput", "Long Strings", c("This is a long long string that is long.",
                                                 "This is a long long string that is longer."))
    ),


    # allows for long texts to not be wrapped, and sets width of drop-down
    tags$head(
      tags$style(HTML('
                      .selectize-input {
                      white-space: nowrap;
                      }
                      #LongInput + div>.selectize-dropdown{
                      width: 660px !important;
   }
                      #userInput + div>.selectize-dropdown{
                      width: 357px !important; maxItems: 21;
                      }
                      '
      )
      )
      )
      )
      ))