Steps to run the RationalNumberTree.java program:
1. Download the zip folder and unpack the .java file and this README. 
2. Create a new project in and IDE of your choosing.
3. In the "src" folder of that project, place the downloaded .java file.
4. Open the file and run the program.

Inputs:
1. Prompt: "Enter the number of tests": 
- Enter the number of "N" ratoinal number tests you want the program to perform.
- This should be an integer value although the code has error handling in case a mistake is made.
2. Prompt: "Enter test #x input":
- Here, x is the test number from 1 to N inclusive.
- The input can only be:
	- A string input representing a tree path composed of "L" and "R" character types for the left and right paths of the binary tree, respectively.
		- The input string should only contain characters L and R, any other alphabet characters will be invalid. For example LR is valid, LRF or SFG are not.
	- A string input representing a rational number of the form p/q, where p and q are big integer types.
		- This should be a rational number which by definition is in it's lowest terms as a fraction. For example, 3/6 = 2/4 = 1/2. However, only 1/2 is a valid input in this program.
This prompt will repeat until the Nth input is completed.

Outputs:
1. Assuming the inputs are valid, the outputs resulting from input 2. will be the following:
- If the input is a tree path, the output will be the corresponding rational number in the form p/q.
- If the input is a rational number, the output will be the corresponding tree path composed of the characters "L" and "R".
2. After the Nth test output, the program will output the total execution time of the computations.
	- Important note: This time is NOT the total running time of the program that includes human idle time. It is only the time elapsed after each computation from the computer.

Example of a valid run of the program:
Pogram prompt: "Enter the number of tests:"
Input: 3
Program prompt: "Enter the test #1 input:"
Input: LRLRL
Output: 8/13
Program prompt: "Enter test #2 input:"
Input: 1/6
Output: LLLLL
Program prompt: "Enter test #3 input:"
Input: LR
Output: 2/3
Output: Total execution time: 0.0142344 seconds

