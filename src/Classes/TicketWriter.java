package Classes;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TicketWriter {
    File output = new File("output.txt");
    FileWriter writer = new FileWriter(output);

    public TicketWriter(String writeIn) throws IOException {
        writer.write(writeIn);
        writer.flush();
        writer.close();
    }

}
