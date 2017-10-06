import java.io.*;
import java.nio.charset.Charset;

/**
 * Class to count specific character in given file
 */
class SingleCharCounter {
    static int get(String filename, char toBeCounted) throws IOException {
        int count = 0;
        BufferedReader reader = new BufferedReader(
                                new InputStreamReader(
                                new FileInputStream(filename),
                                Charset.forName("UTF-8")));
        int c;
        while ((c = reader.read()) != -1) {
            char character = (char) c;
            if (character == toBeCounted) ++count;
        }
        return count;
    }
}
