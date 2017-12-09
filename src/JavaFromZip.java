import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Class that unzips a file and then finds every .java file that contains "transient" or "volatile"
 */
public class JavaFromZip {
    private static firstPattern = "pattern1";
    private static secondPattern = "pattern2";
    private static void unzip(String fileName){
        File zipFile = new File(fileName);
        
        String absath = zipFile.getAbsolutePath();
        String folderPath = absath.substring(0,absath.lastIndexOf(File.separator));

        ZipUtils.extract(zipFile, new File(folderPath));
    }

    static List<Path> getFiles(String fileName) throws IOException {

        List<Path> result = new ArrayList<>(); //initialize result list
        unzip(fileName);

        Path path = Paths.get(fileName.substring(0, fileName.lastIndexOf('.')));
        Stream<Path> fileStream = Files.walk(path).filter(x -> x.toString().endsWith(".java"));

        //iterate through java files
        fileStream.forEach(file -> {
            try{
                //get stream of all lines of the  file 
                Stream<String> fileLinesStream = Files.lines(file); 
                if (fileLinesStream.anyMatch(line -> line.contains(firstPattern) || line.contains(secondPattern))) {
                    result.add(file);
                }
            } 
            catch (IOException e){
                e.printStackTrace();
            }

        });
        return result;
    }
}
