import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Class to get a list of random lines from a text file.
 */
class FileToList {

    static List<String> get(String fileName, int numOfLines) throws IOException{
        if (numOfLines < 0)
            throw new IllegalArgumentException("Number of lines must be non-negative");

        int lineLength = 80;
        File file = new File(fileName);
        List<String> fileList =
                new ArrayList<String>((int) (2* (file.length() / lineLength)));

        int lineCount = 0;
        BufferedReader reader = new BufferedReader(new FileReader(file));
        for (String line = reader.readLine(); line != null; line = reader.readLine()) {
            fileList.add(line);
            ++lineCount;
        }
        reader.close();

        // get random lines from list
        List<String> result = new ArrayList<String>(numOfLines);
        Random random = new Random();
        for (int i = 0; i < numOfLines; ++i) {
            result.add(fileList.get(random.nextInt(lineCount - 1)));
        }
        return result;
    }
}