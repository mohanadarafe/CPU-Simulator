# CPU Simulator
In this assignmenent, we must implement a simulation of a functional CPU using Priority Queue's. The CPU itself takes a Job and processes it. After one cycle, it dumps the job back into the ADT and performs the next one. The goal is to execute three different data structures; Array List based Heap, Sorted & Unsorted Array. A text file will output the final results & compare the performance of each ADT.

## Array List based Heap
The array list based heap involves various methods in order to function properly. First and foremost, any priority queue must contain an `insert()` and `removeMin()` method. Also, it is inevitable that the heap must remain sorted. In total, the complexity the data structure carries is `O(nlogn)`. 
