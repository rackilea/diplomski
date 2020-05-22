require(shiny)
shinyUI(navbarPage("",
            tabPanel("Foo",
               tabsetPanel(
                    tabPanel("Foo1",                            
                              sidebarLayout(
                                  sidebarPanel(tags$div(div(id="Foo2", tags$a("Foo2")))),
                                  mainPanel(p("hello Foo1")))
                     ),
                     tabPanel("Foo2",
                               sidebarLayout(
                                   sidebarPanel(),
                                   mainPanel(p("hello Foo2"))), 
                                   HTML("<script>$('#Foo2').click(function() {
                                        tabs = $('.tabbable .nav.nav-tabs li')
                                        tabs.each(function() {
                                        $(this).removeClass('active')
                                        })
                                        $(tabs[1]).addClass('active')

                                        tabsContents = $('.tabbable .tab-content .tab-pane')
                                        tabsContents.each(function() {
                                        $(this).removeClass('active')
                                        })
                                        $(tabsContents[1]).addClass('active')

                                        $('#Foo2').trigger('change').trigger('shown');

                                        })</script>")
                                   )
                          )
                        ),
            tabPanel("Bar",
               tabsetPanel(
                     tabPanel("Bar1",                            
                               sidebarLayout(
                                   sidebarPanel(tags$div(div(id="Bar2",tags$a("Bar2")))),
                               mainPanel(p("hello Bar1"))
                                   )),
                     tabPanel("Bar2",
                               sidebarLayout(
                                   sidebarPanel(),
                                   mainPanel(p("hello Bar2"))), 
                                   HTML("<script>$('#Bar2').click(function() {
                                        tabs = $('.tabbable .nav.nav-tabs li')
                                        tabs.each(function() {
                                        $(this).removeClass('active')
                                        })
                                        $(tabs[3]).addClass('active')

                                        tabsContents = $('.tabbable .tab-content .tab-pane')
                                        tabsContents.each(function() {
                                        $(this).removeClass('active')
                                        })
                                        $(tabsContents[3]).addClass('active')

                                        $('#Bar2').trigger('change').trigger('shown');

                                        })</script>")










                          )
                          )
                        )
                        )
                          )