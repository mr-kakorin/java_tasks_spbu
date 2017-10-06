import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 * https://docs.google.com/document/d/1y3kaCApOqBC38sE6aZhGJY-6pxXaDnrj7jaN-cNEKUw
 */
public class Main {

    private static void Task1(int m, int n){
        System.out.println("Input: m = " + m + ", n = " + n);
        try {
            System.out.println("%: " + GCD.perc(m, n));
            System.out.println("FloorMod: " + GCD.floorMod(m, n));
            System.out.println("Reminder: " + GCD.rem(m, n));
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    private static void Task2(String toEncode, String toDecode){
        System.out.println("To encode: " + toEncode);

        String encoded = Rot13.encode(toEncode);

        System.out.println("Encoded: " + encoded);
        System.out.println("Decoded: " + Rot13.decode(encoded));

        System.out.println("To decode: " + toDecode);

        String decoded = Rot13.decode(toDecode);

        System.out.println("Decoded: " + decoded);
        System.out.println("Encoded: " + Rot13.encode(decoded));
    }
    private static void Task3(String input){
        try {
            System.out.println("hex-digit: " + input);
            System.out.println("dec-digit: " + HexToDec.get(input));
        } catch (IllegalArgumentException e){
            System.out.println("Error: " + e.getMessage());
        }
    }
    private static void Task4(Scanner Scanner){
        Stream stream = ScannerToStream.get(Scanner);
        stream.forEach(System.out::println);
    }
    private static void Task5(String fileName){
        try {
            List<Path> javaFiles = JavaFromZip.getFiles(fileName);
            javaFiles.forEach(System.out::println);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    private static void Task6(String fileName, char toCount){
        try {
            System.out.println("Character to be counted: " + toCount +"in File:" + fileName);
            int count = SingleCharCounter.get(fileName, toCount);
            System.out.println("Count: " + count);
        } catch (FileNotFoundException e){
            System.out.println("Error: File:" + fileName + " is not found. ");
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    private static void Task7(String fileName, int number){
        try {
            List<String> ListFromFile = FileToList.get(fileName, number);
            for (String line : ListFromFile) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e){
            System.out.println("Error: File:" + fileName + " is not found - ");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e){
            System.out.println("Error: " + e.getMessage());
        }
    }
    private static void Task8(Long seedValue, Long a, Long c, Long m, int num){
        Stream<Long> random = StreamRandomNumbers.get(seedValue, a, c, m);
        random.limit(num).forEach(System.out::println);
    }
    private static void Task9(Stream firstStream, Stream secondStream){
        Stream zippedStream = StreamZipper.zip(firstStream, secondStream);
        zippedStream.forEach(System.out::println);
    }

    public static void main(String[] args) {
        Task1(8, 13);
        Task2(args[0], args[1]);
        Task3("asfasxz");
        Task4(new Scanner(System.in));
        Task5(System.getProperty("prop.test") + "\\task5.zip");
        Task6(System.getProperty("prop.test") + "\\task6.txt", args[0].charAt(0));
        Task7(System.getProperty("prop.test") + "\\task7.txt", 5);
        Task8(128L, 25214903917L, 11L, 2^48L, 12);
        Task9(Stream.of(1, 3, 5, 7, 9, 11), Stream.of(2, 4, 6, 8, 10, 12));
    }
}
