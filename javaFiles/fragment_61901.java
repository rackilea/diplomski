library TESTLIB;
{$DEFINE TESTLIB}

uses
  System.SysUtils,
  System.Classes,
  TestInt in 'TestInt.pas', //here's my unit (interface)
  Vcl.Dialogs,
  ADODB,
  Vcl.Forms;

  {$R *.res}


function MyReturn(Test: PTest): Boolean; stdcall;
var
  ado: TADOQuery;
  con: TADOConnection;
begin
    con := TADOConnection.Create(Application);
    ado := TADOQuery.Create(Application);

    con.ConnectionString := 'Provider=SQLOLEDB.1;Password=aaa;Persist Security Info=True;User ID=aa;Initial Catalog=aa;Data Source=127.0.0.1';
    con.LoginPrompt := False;
    con.Open();

    if con.Connected = True then
        ShowMessage('connected ok')
    else
        ShowMessage('not connected');

    ado.Active := False;
    ado.Connection := con;
    ado.SQL.Clear;
    ado.SQL.Add('select lalala from table where codlala = 1');
    try
        ado.Open();
        Test^.vResult := PAnsiChar(AnsiString(ado.FieldByName('fantasia').AsString));
        Result := True;
    except
        on E: Exception do
        begin
          ShowMessage('error to open the query' + #13 + 'Error: ' + E.Message);
          Result := False;
        end;
    end;
end;

exports MyReturn;

begin
end.