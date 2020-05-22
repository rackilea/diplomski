stt.execute("CREATE EVENT IF NOT EXISTS  AutoDelete "
            + "ON SCHEDULE EVERY 3 MINUTE "
            + "DO BEGIN"
            + "DELETE FROM bus WHERE created_at < (NOW() - INTERVAL 3  MINUTE);"
            + "ALTER TABLE bus AUTO_INCREMENT = 1 ;"
            + "END;");