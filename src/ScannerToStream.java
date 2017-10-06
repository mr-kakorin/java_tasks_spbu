import java.util.Objects;
import java.util.Scanner;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Class to turn Scanner into a Stream
 */
class ScannerToStream{
    static Stream get(Scanner scanner){
        Supplier<Object> scannerNext = () -> scanner.next();
        return Stream.generate(scannerNext);
    }
}