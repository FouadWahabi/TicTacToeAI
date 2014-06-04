TicTacToeAI
===========
This is an unbeatable example of the famious game Tic Tac Toe.
In order to make the game unbeatable, it was necessary to create an algorithm that could calculate all the possible moves available for the computer player and use some metric to determine the best possible move. After extensive research it became clear that the Minimax(alpha-beta-pruning for optimality reasons) algorithm was right for the job.

Visit the link below for a good explanation of the algorithm : 
http://ai-depot.com/articles/minimax-explained/1/

Example to play
===============

First palyer ? y/n\n
y
Choose your marker X/O
X
It's your turn
0 0
| X ||   ||   |
|   ||   ||   |
|   ||   ||   |
Computer turn
| X ||   ||   |
|   || O ||   |
|   ||   ||   | ...
