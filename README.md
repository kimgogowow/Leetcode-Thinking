# Leetcode-Thinking

Here are some questions I regard as "worth-recording", may be some  missing corner case or some interesting solution.

## Medium
** Q402 : Remove K Digits**


Think about all possibilities:


1. all removement is within the num, so k = 0 after first traverse.
 only Stack can help with that
  eg: num = "1432219", k = 3
  
2. "0" can be in the beginning of your finally result,need to do a cleanning before return.
  eg: Input: num = "10200", k = 1
  
3. k > 0 after first traverse, in that case you have to remove the last k char.
  eg: num ="10001", k = 4


* the order of run these method also need considering! Action 3 should be done before Action 2
  
** Q310 : Minimum Height Tree

1. The logic is BFS: remove the outer layer leaves (has only one neighbor) ,like pilling an onion!
2. Great combinations: BFS+Queue   
3. I used to question why just use 'iterator().next()', which returns an int only, I was thinking in this step I am supposed to remove the leave from all other set as well. But!! think about the definition of Leaves!!! they have only one neighbor girl!
4. In the end, think about the result format, it is a List! and n can be odd or even, which means the result can be 1 or 2 int.
