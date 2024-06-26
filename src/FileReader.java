import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileReader {
    String readFileContents(String fileName) {
        String path = "./resources/" + fileName;
        try {
            return Files.readString(Path.of(path));
        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл с отчётом. Возможно, файл отсутствует в нужной директории.");
            return null;
        }
    }


}
