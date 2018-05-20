# Zip Code Parser (Java)

This is an sample project written to demonstrate a problem in which a user provides multiple ranges of zip codes. Our goal is to compact those zip codes for any redundancies over overlaps that may appear.

Example, the user provides [62864,62864] [95811,95816] [95812,95825]. The user is returned
[62864,62864] [95811,95825].


## How to use
This was written with intent to be used under Java 1.8

This is a commandline interface app is to be used from the java commandline. Arguments are outlined in the commandline prompt at runtime.


## Special notes
- Regular expressions are used in attempts to parse initial input from the user. These inputs should suffice, but may have some unintended side-effects. (Such as potentially parsing invalid data)  
- The example project specification is not thorough in it's explanation regarding ranges. For example, it does not state if negative ranges (e.g. [94040,95825]) are invalid input. Reasonably speaking, the options here are either to error if negative ranges are found, or instead to reverse the inputs for the user. In our example, a very basic reverse sanity check is put in through the collapsing process. This collapse process works for our intention of a single-runthrough instance, but is not thorough in it's sanity checks. A proper implementation should ensure sanity checks more aggressively (such as the user modifying the ranges with setters )
- My language of preference with development is to use JavaScript and NodeJS. Therefore, while this application was intended to be written under Java best practices, not all configurations or paradigms may be best practices.
