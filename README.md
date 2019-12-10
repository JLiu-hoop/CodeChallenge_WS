# WS_CodeChallenge 
This is the code challenge from Williams Sonoma, Inc.
Author of srouce code is Jiaho Liu <jliu.itcorp@gmail.com>

Challenge description:

***
BACKGROUND
Sometimes items cannot be shipped to certain zip codes, and the rules for these restrictions are stored as a series of ranges of 5 digit codes. For example if the ranges are:

[94133,94133] [94200,94299] [94600,94699]

Then the item can be shipped to zip code 94199, 94300, and 65532, but cannot be shipped to 94133, 94650, 94230, 94600, or 94299.

Any item might be restricted based on multiple sets of these ranges obtained from multiple sources.

PROBLEM
Given a collection of 5-digit ZIP code ranges (each range includes both their upper and lower bounds), provide an algorithm that produces the minimum number of ranges required to represent the same restrictions as the input.

NOTES
- The ranges above are just examples, your implementation should work for any set of arbitrary ranges
- Ranges may be provided in arbitrary order
- Ranges may or may not overlap
- Your solution will be evaluated on the correctness and the approach taken, and adherence to coding standards and best practices

EXAMPLES:
If the input = [94133,94133] [94200,94299] [94600,94699]
Then the output should be = [94133,94133] [94200,94299] [94600,94699]

If the input = [94133,94133] [94200,94299] [94226,94399] 
Then the output should be = [94133,94133] [94200,94399]

Evaluation Guidelines:
Your work will be evaluated against the following criteria:
- Successful implementation
- Efficiency of the implementation
- Design choices and overall code organization
- Code quality and best practices

***
## Design Pattern
In this challenge, the first pattern shown in my mind is Anti Pattern. 
Anti-Patterns are certain patterns in Java Software development that is considered a bad programming practice. Put all methods in one class, God Object is example of Anti-Pattern. Here God Object means all operations are performed only one object. For example,
```
class GodObject {
   function PerformInitialization () {}
   function ReadFromFile () {}
   function WriteToFile () {}
   function DisplayToScreen () {}
   function PerformCalculation () {}
   function ValidateInput () {}
   // and so on... //
}
```
It's not a good habit, and easy to make mistakes. I am going to use Design Pattern to splite my source code. For example,

```
class ReadFile{
    try{

    } catch(IOException io){

    }
}

class WriteFile{
    try{

    } catch(IOException io){
        
    }
}

class LogicClass{
  ReadFile rf = new ReadFile();
  WriteFile wf = new WriteFile();
}
```
So, any piece of code has bugs, I can easy to local it and fix it.

![image](https://user-images.githubusercontent.com/58745796/70560290-31c26580-1b3d-11ea-93ad-c1bd57c232c7.png)


Other design patterns also can used in this code challenge, and I am going to optimize my source code in the future.

## Test Cases
Unit Test is the most import steps for Software Development Engineers. Nobody can write the code without bugs at very beginning. Therefore, a good and high coverage rate test case is very important. 
Here, I give several test cases:

- Excepted input
- Empty input
- Malformed input
- Iarge input
- Null input
- Alphabet input
- Outbound input

![image](https://user-images.githubusercontent.com/58745796/70560128-e27c3500-1b3c-11ea-89f0-32170636068f.png)


I surly believe that there other edge cases I didn't covert. For this challenge, those test cases input should good enought to handle all kind input csv files.

## Encapsulation
Encapsualtion is one of the four OOPs concepts which can protect the data from Enterprises's database.
Human error is inevitable, so set data from database into private can protect those kind mistakes.

![image](https://user-images.githubusercontent.com/58745796/70560253-1eaf9580-1b3d-11ea-9fcd-13a9a87242cf.png)


Also, it's a really good habit to use Encapsulation in OOPs language

