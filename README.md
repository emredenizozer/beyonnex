### Java AnagramChecker Program Explanation

## Overview

The Java program <b>AnagramChecker</b> provides functionality to check if two strings are anagrams and to retrieve all anagrams of a given string based on previous inputs.

## How to run the program

Just run the main method inside /src/AnagramChecker.java file using any IDE. It uses Java 21.

</br>

If you want to run it from the terminal:

- Compile the program:
    ```
    javac AnagramChecker.java
    ```

- Run the program:
    ```
    java AnagramChecker
    ```

</br>

The program runs in a loop, allowing the user to repeatedly check for anagrams or retrieve anagrams until they choose to exit.

## Features

1. <b>Check if two texts are anagrams of each other</b>

    - The <b>areAnagrams(String text1, String text2)</b> method checks if <b>text1</b> and <b>text2</b> are anagrams.
    - It removes spaces and converts characters to lowercase for case insensitivity.
    - It sorts the characters of both texts and compares them.
    - If they are anagrams, it adds them to the <b>anagramMap</b>.

2. <b>Get all anagrams for a given string</b>

    - The <b>getAnagrams(String text)</b> method retrieves all anagrams for <b>text</b> based on previous inputs.
    - It retrieves the sorted version of <b>text</b> and uses it as a key to fetch anagrams from <b>anagramMap</b>.
    - It removes <b>text</b> itself from the list of anagrams before returning them.

3. <b>main Method:</b>

    - Provides an interactive terminal interface for the user.
    - Supports commands to check if two texts are anagrams (1) and to get all anagrams for a given text (2).
    - Allows the user to exit the program (3).


</br>

## Implementation Details

- <b>Map Structure:</b> "anagramMap" is a HashMap<String, List< String>> where:
    - Key (String): Sorted version of a text (<b>getSortedString</b> method is used for sorting).
    - Value (List< String>): List of original texts that are anagrams of the sorted key.

- <b>Sorting:</b> The <b>getSortedString(String text)</b> method:
    - Removes spaces and converts characters to lowercase.
    - Sorts the characters using <b> Arrays.sort</b>.

- <b>Adding Anagrams:</b> The <b>addAnagramPair(String text1, String text2)</b> method:
    - Uses <b>getSortedString</b> to get sorted versions of <b>text1</b> and <b>text2</b>.
    - Adds each text to the list of anagrams for its sorted version in <b>anagramMap</b>, avoiding duplicates.

</br>

## Sample main function for adding sample inputs and checking anagrams

If it is needed, one can add the lines inside the main function below to the main function that I used inside AnagramChacker class to provide sample inputs and check if there are anagrams in the inputs that are provided.

```

        public static void main(String[] args) {

        // Adding sample inputs to the program

        areAnagrams("listen", "silent");
        areAnagrams("listen", "enlist");
        areAnagrams("rat", "tar");
        areAnagrams("god", "dog");
        areAnagrams("evil", "vile");
        areAnagrams("a gentleman", "elegant man");
        areAnagrams("eleven plus two", "twelve plus one");
        areAnagrams("rat", "car");
        areAnagrams("god", "good");
        areAnagrams("evil", "veil");



        // Checking anagrams for a given string

        System.out.println("Anagrams for 'listen': " + getAnagrams("listen"));
        System.out.println("Anagrams for 'silent': " + getAnagrams("silent"));
        System.out.println("Anagrams for 'enlist': " + getAnagrams("enlist"));
        System.out.println("Anagrams for 'rat': " + getAnagrams("rat"));
        System.out.println("Anagrams for 'tar': " + getAnagrams("tar"));
        System.out.println("Anagrams for 'god': " + getAnagrams("god"));
        System.out.println("Anagrams for 'dog': " + getAnagrams("dog"));
        System.out.println("Anagrams for 'evil': " + getAnagrams("evil"));
        System.out.println("Anagrams for 'vile': " + getAnagrams("vile"));
        System.out.println("Anagrams for 'veil': " + getAnagrams("veil"));
        System.out.println("Anagrams for 'a gentleman': " + getAnagrams("a gentleman"));
        System.out.println("Anagrams for 'elegant man': " + getAnagrams("elegant man"));
        System.out.println("Anagrams for 'eleven plus two': " + getAnagrams("eleven plus two"));
        System.out.println("Anagrams for 'twelve plus one': " + getAnagrams("twelve plus one"));
        System.out.println("Anagrams for 'car': " + getAnagrams("car"));
        System.out.println("Anagrams for 'good': " + getAnagrams("good"));
    }

```