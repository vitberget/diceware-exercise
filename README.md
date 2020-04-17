# Diceware exercice

[Read about Diceware][homepage]

## Dice

Since there can be some confusion in generating proper 
dicerolls, there is `DiceTest`.

## Wordmapping

A [wordlist], standard english, is downloaded from Diceware 
and can be found in [resources][wordlist-resource].

Testing is done in `WordmappingTest`

## Random letter

To increase the security, one can use a random letter to replace 
a random letter in a random word.

Test of the random character is done in `RandomLetterTest`

## The main

Finally, implement the main() in `Application.kt`, 
no test here though - to lazy to write some test for ... random.

 

[homepage]: http://world.std.com/~reinhold/diceware.html
[wordlist]: http://world.std.com/%7Ereinhold/diceware.wordlist.asc
[wordlist-resource]: src/main/resources/se/vbgt/diceware/diceware.wordlist.asc