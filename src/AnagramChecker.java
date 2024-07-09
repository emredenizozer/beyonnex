import java.util.*;

public class AnagramChecker {
    private static final Map<String, List<String>> anagramMap = new HashMap<>();

    // Feature 1: Check if two texts are anagrams of each other
    public static boolean areAnagrams(String text1, String text2) {
        if (text1 == null || text2 == null) {
            return false;
        }

        char[] arr1 = text1.replaceAll("\\s", "").toLowerCase().toCharArray();
        char[] arr2 = text2.replaceAll("\\s", "").toLowerCase().toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        boolean isAnagram = Arrays.equals(arr1, arr2);

        if (isAnagram) {
            addAnagramPair(text1, text2);
        }

        return isAnagram;
    }

    // Helper method to add anagram pairs to the map
    private static void addAnagramPair(String text1, String text2) {
        String sortedText1 = getSortedString(text1);
        String sortedText2 = getSortedString(text2);

        // Ensure we always use the sorted version as the key
        anagramMap.putIfAbsent(sortedText1, new ArrayList<>());
        if (!anagramMap.get(sortedText1).contains(text1)) {
            anagramMap.get(sortedText1).add(text1);
        }

        if (!text1.equals(text2)) { // Avoid adding the same text as its own anagram
            anagramMap.putIfAbsent(sortedText2, new ArrayList<>());
            if (!anagramMap.get(sortedText2).contains(text2)) {
                anagramMap.get(sortedText2).add(text2);
            }
        }
    }

    // Helper method to get the sorted string
    private static String getSortedString(String text) {
        char[] chars = text.replaceAll("\\s", "").toLowerCase().toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    // Feature 2: Provide all the anagrams for a given string based on previous inputs
    public static List<String> getAnagrams(String text) {
        String sortedText = getSortedString(text);
        List<String> anagrams = new ArrayList<>(anagramMap.getOrDefault(sortedText, new ArrayList<>()));
        anagrams.remove(text); // Remove the original text from the list
        return anagrams;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1: Check if two texts are anagrams");
            System.out.println("2: Get all anagrams for a given string");
            System.out.println("3: Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("Enter first text:");
                    String text1 = scanner.nextLine();
                    System.out.println("Enter second text:");
                    String text2 = scanner.nextLine();
                    boolean result = areAnagrams(text1, text2);
                    System.out.println("Are anagrams: " + result + "\n");
                    break;
                case 2:
                    System.out.println("Enter text:");
                    String text = scanner.nextLine();
                    List<String> anagrams = getAnagrams(text);
                    System.out.println("Anagrams: " + anagrams + "\n");
                    break;
                case 3:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }
}
