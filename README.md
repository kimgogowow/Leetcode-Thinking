# Leetcode-Thinking

Here are some questions I regard as "worth-recording", may be some  missing corner case or some interesting solution.

## Medium
**Q402 : Remove K Digits**


Think about all possibilities:


1. all removement is within the num, so k = 0 after first traverse.
 only Stack can help with that
  eg: num = "1432219", k = 3
  
2. "0" can be in the beginning of your finally result,need to do a cleanning before return.
  eg: Input: num = "10200", k = 1
  
3. k > 0 after first traverse, in that case you have to remove the last k char.
  eg: num ="10001", k = 4


* the order of run these method also need considering! Action 3 should be done before Action 2
  
