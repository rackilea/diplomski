<%
            Connection con = null;
            ResultSet rs = null;
            ArrayList<String> ar=new ArrayList<String>();
            String taxgroup;


            try {
                 DBConnect db = new DBConnect();
                 con = db.getCon();
                 String sql = "select distinct TaxGroup from marketing_database.tax_info";
                 PreparedStatement smt = con.prepareStatement(sql);
                 rs = smt.executeQuery();

                 while(rs.next())
                 {
                     taxgroup=rs.getString(1);

                        ar.add(taxgroup);
                        System.out.println("Array is" +ar);
                 }
                 int size = ar.size();


                 System.out.println("size is" +size);

            %>
            <%
            con.close();
            smt.close();
            rs.close();

            }
            catch(SQLException ex){
                ex.printStackTrace();
              }

            %>

 var cell7 = row.insertCell(6);

          var element7 =  document.createElement("select");
          element7.setAttribute('multiple', '');
          var jsArray = [];
          <%for(int i=0;i<ar.size();i++){%>
              jsArray.push("<%= ar.get(i)%>");
          <%}%>


         //   var optarr =  ["vat1","vat2","vat3","vat4","vat5","vat6","vat7","vat8","vat9"];
          alert(jsArray.length);
          alert(jsArray);
          for(var i = 0;i<jsArray.length;i++)
          { 
           var opt = document.createElement("option");
           opt.text = jsArray[i];

           opt.value = jsArray[i];
           opt.className = jsArray[i];
           element7.appendChild(opt);
          } 
element7.setAttribute('id', 'vat5'); //set the id attribute 
         element7.setAttribute('name','tax'+rowCount);
         element7.setAttribute('value','vat5');

         cell7.appendChild(element7);