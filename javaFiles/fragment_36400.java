Method OnProcessInput(pLine As Ens.StringContainer, Output pLineLeftOver As Ens.StringContainer) As %Status
{
    Set val = 0
    $$$TRACE(val)

    Set gateway = ##class(%Net.Remote.Gateway).%New()
    Do gateway.%Connect("127.0.0.1", 55555)

    Set javaObj = ##class(packageName.EnterTestClass).%New(gateway)
    Set val = javaObj.enter()

    $$$TRACE(val)
    Quit $$$OK   
}