# Word-Puzzle-Solver
Cross Word Puzzle Solver

Aim: To build a cross word puzzle solver.

A grid consisting of letters is to be checked against a dictionary of words
to see if the grid contains any of the words.
The user can input a value for the rows and columns of the grid and the program
will create a grid of random characters.
The program will read in a dictionary file (provided) and use an algorithm to
solve the word puzzle.


I have used Hash table to store the dictionary.

The user also has the option of using one the following two algorithms:

1) Normal: Only complete words are stored in the hash table from the given dictionary file.

2) Enhanced: When reading the dictionary file, we store each prefix of the word as well.
       For example, if the word is "apple", we store "a", "ap", "app", "appl", "apple" into the hash table.
       Further ,in the algorithm, while matching words; if a prefix is not found, the rest of the string being matched can be
       treated as "not found".
	   
I have also displayed the elapsed time (time taken while searching for words, not including the time for loading the dictionary into hash table) in both cases.