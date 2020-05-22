"""
    create procedure tryBaru_Procedure(v_name varchar(50),v_city varchar(20),out v_id int)
        let v_id = 10;
    end procedure;
"""

def test_call(db_url, usr, passwd):
    try:
        print("\n\n%s\n--------------\ncall..." % (db_url))
        db = DriverManager.getConnection(db_url, usr, passwd)
        proc = db.prepareCall("{ call tryBaru_Procedure(?, ?, ?) }");
        proc.setString(1, 'v_name')
        proc.setString(2, 'v_city')
        proc.registerOutParameter(3, Types.VARCHAR)
        proc.executeUpdate();
        v_id = proc.getInt(3)
        print('v_id: %s' % (v_id))
        db.close()
    except:
        print("there were errors!")
        s = traceback.format_exc()
        sys.stderr.write("%s\n" % (s))