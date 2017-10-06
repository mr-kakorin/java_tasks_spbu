import static java.lang.Math.abs;
import static java.lang.Math.floorMod;

/**
 * Recursive implementation of GCD's GCD algorithm with three different operations
 */
class GCD {

    static int perc(int m, int n) {
        return n == 0 ? m : perc(n, m % n);
    }

    static int floorMod(int m, int n) {
        return n == 0 ? m : perc(n, floorMod(m, n));
    }

    static int rem(int m, int n) { return n == 0 ? m : perc(n, abs(m % n)); }

}