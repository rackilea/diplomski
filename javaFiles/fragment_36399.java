package packageName;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class EnterTestClass {

    public long enter() throws IOException {

        File file = new File("D:\\Path\\EnterTestClass.txt");

        if (!file.exists()) {
            file.createNewFile();
        }

        BufferedWriter bf = new BufferedWriter(new FileWriter(file.getAbsoluteFile()));
        bf.write(LocalDateTime.now().toString());
        bf.close();

        return 1;
    }
}