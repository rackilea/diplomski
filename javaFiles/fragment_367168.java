response = Jsoup.connect(url)
.cookies(response.cookies()) // Add cookies received when fetching the first page
.data("__VIEWSTATE", viewState.attr("value"))
.data("__EVENTVALIDATION", eventValidation.attr("value"))
.data("ctl00$MainContent$txtSearchBox", "apple")  // <- search 
.data("ctl00$MainContent$btnCorpSearch", "Search")
.data("ctl00$MainContent$ddlCorpSortColumns", "m")
.data("ctl00$MainContent$ddlCorpNumSortColumns", "m")
.data("ctl00$MainContent$ddlOfficerSortColumns", "m")
.data("ctl00$MainContent$ddlRASortColumns", "m")
.data("ctl00$MainContent$ddlABNSortColumns", "m")
.data("ctl00$MainContent$ddlABNSortColumns", "m")
.data("ctl00$MainContent$rdlSortOrder", "d")
.data("ctl00$MainContent$objSearchGrid$dgCorpSearchResults$ctl54$ctl01", "")
.method(Connection.Method.POST)
.followRedirects(true)
.execute();