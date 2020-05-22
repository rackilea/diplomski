...
    matrix = RectangularArrays.ReturnRectangularStringArray(a + 1, a + 1)
...
Friend Module RectangularArrays
    Friend Function ReturnRectangularStringArray(ByVal size1 As Integer, ByVal size2 As Integer) As String()()
        Dim newArray As String()() = New String(size1 - 1)() {}
        For array1 As Integer = 0 To size1 - 1
            newArray(array1) = New String(size2 - 1) {}
        Next array1

        Return newArray
    End Function
End Module