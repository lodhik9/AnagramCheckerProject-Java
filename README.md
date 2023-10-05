# Anagram Checker

This is a simple Java program to check if two words are anagrams of each other. It also stores found anagrams and can find all anagrams for a given word.

## Features

1. Check if two words are anagrams

2. Store found anagram pairs in a map

3. Find all existing anagrams for a given word

4. Case insensitive anagram checking

5. Input loop to continually check for anagram

## Usage

The program prompts the user to enter two words at a time to check if they are anagrams.

Type 'quit' to exit the input loop.

After exiting the input loop, the program prompts for a word to display all cached anagrams.

## Implementation

The core logic is implemented in the AnagramChecker class.

Key methods:

1. isAnagram() - Checks if two words are anagrams
2. storeAnagram() - Stores found anagrams in a map
3. findAnagrams() - Gets stored anagrams for a word

The main() method contains the input loop and logic to call AnagramChecker methods.
