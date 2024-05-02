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
  
**Q310 : Minimum Height Tree**

1. The logic is BFS: remove the outer layer leaves (has only one neighbor) ,like pilling an onion!
2. Great combinations: BFS+Queue   
3. I used to question why just use 'iterator().next()', which returns an int only, I was thinking in this step I am supposed to remove the leave from all other set as well. But!! think about the definition of Leaves!!! they have only one neighbor girl!
4. In the end, think about the result format, it is a List! and n can be odd or even, which means the result can be 1 or 2 int.

**Q2441: find max k**
1. my own solution in the beginning is using HashSet + List
  ** Hashset is for the contains() and list is for the Collection.sort(). but the complexity will be big
    space com = O(2n)=O(n)  Time com = O(2n) = O(n)

   but this will still slower the processing
   Using a HashSet and a List in Java can indeed maintain the same O(n) time complexity for the operation of checking if an element exists in the set or list. However, the performance difference you’re noticing may be due to several factors:

*Hashing Overhead*: For a HashSet, every time you add or check for an element, the hash code of the element is computed. This hashing process can add overhead, especially if the hash function is complex.

*Collision Handling*: In a HashSet, collisions can occur when two elements have the same hash code. Handling these collisions can add extra time, particularly if the set becomes large.

*Dynamic Resizing*: Both HashSet and ArrayList can dynamically resize when they run out of space. This resizing involves creating a new array and copying all the elements over, which can be time-consuming.

*Cache Locality*: Arrays often have better cache locality compared to objects like HashSet and ArrayList. This means that when you’re iterating over an array, the elements are stored contiguously in memory, making it faster to access sequentially due to the way CPU caching works.

*Constant Factors*: Even though the big-O notation describes the asymptotic behavior, constant factors can still play a significant role. The operations in a HashSet or ArrayList might have higher constant factors compared to a simple array access.

*List Traversal*: If you’re using a List and checking for the existence of an element by traversing the list, it’s an O(n) operation each time, leading to an overall time complexity of O(n^2) for repeated checks.



In summary, while the theoretical time complexity might be the same, practical performance can vary due to factors like overhead, collision handling, resizing, cache effects, and constant factors. That’s why, in practice, using a simple array can be faster than using a HashSet or List for certain operations, despite having the same big-O time complexity.
