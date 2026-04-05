# A7 Guessing Game

Each student should complete this README individually, even when pair programming.

## Basic Information

Your name: Michelle Jiang

Programming partner name, if any:

Other collaborators, including TAs:

If anyone was particularly helpful, please give them a shout-out here:

## References

Any references or resources used besides JavaDoc and course materials:

https://stackoverflow.com/questions/196830/what-is-the-easiest-best-most-correct-way-to-iterate-through-the-characters-of-a

https://www.w3schools.com/java/java_type_casting.asp

https://www.w3schools.com/java/java_files_read.asp

If you used generative AI, how did you use it? What role did it play in your learning?

## Questions to Answer

How does your `DecisionTree` class differ from the base `BinaryTree<String>` class?

The decision tree class is able to follow the paths of various nodes and write into files, extending the binary tree base class. It basically makes it more of a decision specific thing instead of a basic binary tree. 

How does your program decide whether to move left or right while playing the guessing game?

It decides based on whether the answer the user gave was yes or no, if it's yes then it would move to the left and if it's no then it'd move to the right. This continues until it reaches a leaf node (which would be an animal).

How does your program update and save what it learned after an incorrect guess?

The program is able to read files in the beginning and after getting it wrong it would ask the user for the animal and a question that would distinguish the animal it guessed from the correct animal and create another question node and a leaf node for it. 

## Reflection

Please provide a brief reflection on your experience with this assignment. What was most challenging? What was most interesting? What did you learn about representing decisions with trees?

I found this assignment quite interesting and quite challenging, I think for me, in general getting started is the hardest part but once I do, it's much easier. I think for me understanding the instructions and being able to apply what we learned in class was very helpful and interesting and it was nice to create what was basically a game. Through this assignment, I learned how important data structure traversal is and how small mistakes in how you store or reconstruct data can completely break the program’s logic.