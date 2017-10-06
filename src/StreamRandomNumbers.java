import java.util.stream.Stream;

/**
 * Class that generates an infinite stream of random numbers by implementing linear congruential generator.
 */
public class StreamRandomNumbers {

    public static Stream<Long> get(long seedValue, long a, long c, long m) {
        return Stream.iterate(seedValue, e -> (a * e + c) % m);
    }
}