# Tic Tac Toe

`tic-tac-toe` is a text based emulation of game Tic Tac Toe in Java.

# Version 0.1

  - Two Player ( X and O)
  - Text based

# Download
Download the jar from **[release]** and run the jar
```sh
$ java -jar tic-tac-toe-${version}-exec.jar
```

# How to Play
Like paper based Tic Tac Toe game, the player who succeeds in placing three of their marks in a horizontal, vertical, or diagonal row wins the game.

In this edition, we accept any grid size but the winner is the one who succeeds in placing three consecutive marks.
In later edition, we will make it based on users input.

```
Please enter GRID size (N) or press ENTER to set default value (= 3)
>> 3

Please enter Player1's name (X) or press ENTER to skip
>> Dark Knight

Please enter Player2's name (O) or press ENTER to skip
>> Bane

Let the game begin!
 1 |   2 |   3
 ------------------
 4 |   5 |   6
 ------------------
 7 |   8 |   9
Its Dark Knight's turns to play (X)
>> 5

 1 |   2 |   3
 ------------------
 4 |   X |   6
 ------------------
 7 |   8 |   9
Its Bane's turns to play (O)
>> 3
```

# Contribute
  - Clone the repository
```sh
$ git clone https://github.com/mr-pathak/tic-tac-toe
```
  - Checkout to the source code directory
```sh
$ cd tic-tac-toe/
```
  - Build the project from source using Maven
```sh
$ mvn clean install
```
  - Executable Jar is created in `target/` folder
```sh
$ java -jar target/tic-tac-toe-${version}-exec.jar
```

# Todos

 - Play in series mode (tournament for two players)
 - Write Unit tests
 - Write Integration tests
 - Create Single Player Mode (Min Max algorihtm to play against CPU)

# License

MIT
**Free Software**


# Author
[Mitesh Pathak]

   [git-repo-url]: <https://github.com/mr-pathak/tic-tac-toe>
   [release]: <https://github.com/mr-pathak/tic-tac-toe/releases/tag/v0.1>
   [Mitesh Pathak]: <http://miteshpathak.com>
   
