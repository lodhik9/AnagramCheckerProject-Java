import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/* Name: Muhammad Lodhi  
 * Purpose: This AnagramChecker class will act as the central class that provides the anagram features.
 * Methods: isAnagram(String str1, String str2), 
 *          storeAnagram(String str1, String str2),
 *          findAnagrams(String str),
 *          main(String[] args)
*/

public class AnagramChecker {

  private Map<String, String[]> anagramsMap;
  
  public AnagramChecker() {
    anagramsMap = new HashMap<>();
  }

  public boolean isAnagram(String str1, String str2) {
    if(str1.length() != str2.length()) {
      return false;
    }

    str1 = str1.toLowerCase(); 
    str2 = str2.toLowerCase();

    char[] charArray1 = str1.toCharArray();
    char[] charArray2 = str2.toCharArray();

    Arrays.sort(charArray1);
    Arrays.sort(charArray2);

    return Arrays.equals(charArray1, charArray2);
  }

  public void storeAnagram(String str1, String str2) {
    String[] arr = anagramsMap.getOrDefault(str1, new String[0]);
    String[] newArr = Arrays.copyOf(arr, arr.length + 1);
    newArr[newArr.length - 1] = str2;
    anagramsMap.put(str1, newArr);

    arr = anagramsMap.getOrDefault(str2, new String[0]);
    newArr = Arrays.copyOf(arr, arr.length + 1);
    newArr[newArr.length - 1] = str1;
    anagramsMap.put(str2, newArr);
  }

  public String[] findAnagrams(String str) {
    return anagramsMap.getOrDefault(str, new String[0]);
  }

  public static void main(String[] args) {
    AnagramChecker checker = new AnagramChecker();

    Scanner scanner = new Scanner(System.in);

    while (true) {
      System.out.println("Enter first string (or 'quit' to exit):");
      String str1 = scanner.nextLine();
      if (str1.equalsIgnoreCase("quit")) {
        break;
      }

      System.out.println("Enter second string:");
      String str2 = scanner.nextLine();

      if (checker.isAnagram(str1, str2)) {
        checker.storeAnagram(str1, str2);
        System.out.println(str1 + " and " + str2 + " are anagrams.");  
      } else {
        System.out.println(str1 + " and " + str2 + " are NOT anagrams.");
      }
    }

    System.out.println("Enter string to find anagrams:");
    String input = scanner.nextLine();

    System.out.println("Anagrams for " + input + ": " +  Arrays.toString(checker.findAnagrams(input)));
    scanner.close();
  }
}