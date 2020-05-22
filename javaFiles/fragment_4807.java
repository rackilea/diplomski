JSONObject json = new JSONObject();
          ResultSet sections = null;
          ResultSet questions = null;
          JSONObject section = null;
          JSONObject question = null;
          Db d = new Db();


          d.makeJDBCConnection();
          sections = d.getSections();
          while(sections.next()){

              section = new JSONObject();
              // initialize new one inside every iteration

              section.put("name", sections.getString("sectionName"));
              section.put("id", sections.getInt("id"));
              questions = d.getQuestions(sections.getInt("id"));
              while(questions.next()){
                  // id, statement

                  question = new JSONObject();
                  // initialize new one inside every iteration

              question.put("id", questions.getInt("id"));
                  question.put("statement", questions.getString("statement"));
                  section.put("questions", question);
              }
          json.append("section", section);
          // ^^ add every created record 
          // should be inside the loop
          }