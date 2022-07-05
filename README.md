# Java, multi-threaded programming.
# Instructions for launching
#### (Problem statement is in the second half of the file)
When the main method is run, the program waits for a value to be entered in the console:
* "0" - skip file upload
* "1" - loading test data with payments located in the startBalance.txt file (located in the project root directory)
* Indication of the full path to the file with payments, which will be read when the program starts

The end of the program is to enter the quit command in the console

Exchange rates relative to USD for the bonus task are stored in the HashMap usdCurrency and are filled when the program starts in the getUsdCurrency() method <br>

When entering a balance change operation from the console, the entered string will be checked for the presence of two words (separated by a space) and for a number (amount of money) in the second word. <br>
Monetary amounts are stored in BigDecimal format <br>

When reading the starting balance in a file, FileNotFoundException and IOException checks are made

# Formulation of the problem
## General description
Write an application for accounting payments. <br>
Each payment is described by the amount and currency. <br>
Once a minute, the program should display the current balance for all currencies in the console. <br>
Data entry is done through the console. <br>
It should also be possible to specify a text file with payments, which will be read when the program starts.
### Examples of input data:
*USD 1000
* HKD 100
* USD -100
* RMB 2000
* HKD 200
### With the specified data, the program should display the balance:
*USD 900
* RMB 2000
* HKD 300
### Detailed requirements
The file, which can be specified at startup, will contain payment data in the same format: currency code and amount separated by a space, one payment per line.<br>
The balance is displayed once per minute. If for some currency the current balance is 0, the line corresponding to it is not displayed.<br>
The program terminates if the user types quit and presses Enter.<br>
The user may enter incorrect data; this situation should be handled by the developer at his own discretion (readme.txt should describe exactly how the program handles errors).<br>
The source codes of the program must be placed in Git: GitHub, BitBucket. It is recommended to use Maven to build and run the application. The description of the program (readme.txt) should contain instructions for launching. <br>
## Bonus
Additionally, you can implement the ability to specify exchange rates relative to USD and display the balance in USD for each of the currencies:
*USD 900
* RMB 2000 (USD 314.60)
* HKD 300 (USD 38.62)


1. When reading a file with a starting balance, FileNotFoundException and IOException errors are handled <br>
2. When entering a transaction string with an account, it is checked that there are two words separated by one space. Also, the second word should contain only numbers without letters (sum)
