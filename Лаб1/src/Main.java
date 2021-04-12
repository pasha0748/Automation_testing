import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
//        Scanner inD = new Scanner(System.in);
//        System.out.println("Enter Fahrenheit -> ");
//        System.out.println(celsiusToFahrenheit(inD.nextDouble()));
//
//        Scanner inI = new Scanner(System.in);
//        System.out.println("Enter number to reverse -> ");
//        System.out.println(reverse(inI.nextInt()));
//
//        System.out.println("Enter number to know if it is a palindrome -> ");
//        System.out.println(isPalindrome(inI.nextInt()));
//
//        System.out.println("Enter number for palindrome -> ");
//        palindromeNumber(inI.nextInt());
//
//        inD.close();
//        inI.close();
//
//        countVowelsAndConsonants("Bruh, look at this dude!");

        System.out.println(getBucketCount(3.4, 2.1, 1.5, 2));
        System.out.println(getBucketCount(3.4, 2.1, 1.5));
        System.out.println(getBucketCount(6.26, 2.2));
    }

    //Ex1
    /**
     * @param d double
     * @return double
     */
    public static double celsiusToFahrenheit(double d) {
        return (1.8d * d + 32);
    }

    //Ex2
    /**
     * @param num int
     */
    public static void palindromeNumber(int num) {
        System.out.println(isPalindrome(num) ? num + " is a palindrome" : num + " isn't palindrome");
    }

    //Ex3
    /**
     * @param s String
     */
    public static void countVowelsAndConsonants(String s) {
        Pattern p1 = Pattern.compile("[aeiouy]", Pattern.CASE_INSENSITIVE), p2 = Pattern.compile("[b-df-hj-np-tv-xz]", Pattern.CASE_INSENSITIVE);
        Matcher m1 = p1.matcher(s), m2 = p2.matcher(s);
        int vowels = 0, consonants = 0;
        while (m1.find()) {
            vowels++;
        }
        while (m2.find()) {
            consonants++;
        }
        System.out.println("Vowels = " + vowels + "\nConsonants = " + consonants);
    }

    //Ex4
    /**
     * @param num int
     * @return int
     */
    public static int reverse(int num) {
        StringBuilder numRev = new StringBuilder(((Integer) num).toString());
        numRev = numRev.reverse();
        return Integer.parseInt(String.valueOf(numRev));
    }

    /**
     * @param num int
     * @return boolean
     */
    public static boolean isPalindrome(int num) {
        return reverse(num) == num;
    }

    //___________________________________________________________________________Extra Ex______________________________________________________________________________

    /**
     * @param width         double
     * @param height        double
     * @param areaPerBucket double
     * @param extraBuckets  int
     * @return int
     */
    //ex1.1
    public static int getBucketCount(double width, double height, double areaPerBucket, int extraBuckets) {
        if (width <= 0 || height <= 0 || areaPerBucket <= 0 || extraBuckets <= 0) {
            return -1;
        }
        return (int) Math.ceil(width * height / areaPerBucket) - extraBuckets;
    }

    /**
     * @param width         double
     * @param height        double
     * @param areaPerBucket double
     * @return int
     */
    //ex1.2
    public static int getBucketCount(double width, double height, double areaPerBucket) {
        if (width <= 0 || height <= 0 || areaPerBucket <= 0) {
            return -1;
        }
        return (int) Math.ceil(width * height / areaPerBucket);
    }

    /**
     * @param area          double
     * @param areaPerBucket double
     * @return int
     */
    //ex1.3
    public static int getBucketCount(double area, double areaPerBucket) {
        if (area <= 0 || areaPerBucket <= 0) {
            return -1;
        }
        return (int) Math.ceil(area / areaPerBucket);
    }


}