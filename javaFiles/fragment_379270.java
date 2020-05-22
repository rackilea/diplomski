private void statement(){
    if (token == '{') {
        do {
            statement();
        } while (token() != '}');
    } else if(token() == 'I'){
      ifstmt();
    }else if(token() == 'D'){
      doloop();
    }else if(token() == 'R'){
      read();
    }else if(token() == 'O'){
      output();
    } else {
      assnmt();
    }
}