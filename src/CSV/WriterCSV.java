package WriterCSV;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class WriterCSV {

    public static void main(String[] args) {
        try (PrintWriter writer = new PrintWriter(new File("test.csv"))) {

            StringBuilder sb = new StringBuilder();
            sb.append("id");
            sb.append(",");
            sb.append("Text");
            sb.append('\n');

            sb.append("1");
            sb.append(",");
            sb.append("First shit");
            sb.append('\n');

            sb.append("2");
            sb.append(",");
            sb.append("Second shit");
            sb.append('\n');

            writer.write(sb.toString());

            System.out.println("done!");

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
