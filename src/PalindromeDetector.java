/**
 * Class that online detects palindromes using Rabin–Karp hash-algorithm
 */
public class PalindromeDetector {
    private final static int d = 256;
    private final static int q = 103;

    public static void detect(String source)
    {
        int n = source.length();
        // A single character is always a palindrome
        System.out.println(source.charAt(0)+" is palindrome");

        // Return if string has only one character
        if (n == 1) return;

        int hSource = source.charAt(0)%q,
            hPattern = source.charAt(1)%q;

        int h=1,
            i,
            j;

        for(i=1; i<n; ++i){
            if (hSource == hPattern){
                for(j=0;j<i>>1;++j){
                    if(source.charAt(j)!=source.charAt(i-j))
                        break;
                }
                System.out.println((j == i>>1) ? source.substring(0,i+1)+" is a palindrome" : source.substring(0,i+1)+" is not a palindrome");
            }
            else
                System.out.println(source.substring(0,i+1)+" is not a palindrome");

            if(i != n-1){
                if( (i&1) == 0){
                    h = (h*d)%q;
                    hSource = (hSource+h*source.charAt(i>>1))%q;
                    hPattern = (hPattern*d+source.charAt(i+1))%q;
                }
                else{
                    // remove first character
                    hPattern = d * (hPattern + q - source.charAt((i + 1)>>1) * h) % q;
                    // add next character to the end of pattern
                    hPattern = (hPattern + source.charAt(i + 1)) % q;
                }
            }
        }
    }
}
