# Linked List
The advantages of a collection using a linked list instead of an array are the following:
- Arrays have limited size, linked list however has a dynamic size.
- Arrays always use the same amount of memory, so either to much memory is used or the array is always full.
Whereas a linked list only uses as much space as required. However linked list nodes are objects so have the overhead of not just being primitve types, they also have to keep references.

| Operations             | Time Complexities                                                                                                               |   |   |   |
|------------------------|---------------------------------------------------------------------------------------------------------------------------------|---|---|---|
| add(E e)               | O(1) when using addHead() O(n) when using addTail() O(1) when using addTail() and have reference to last                        |   |   |   |
| remove(Object o)       | O(n) the prev of the to be removed link is assigned prev.next = toBeDeleted.next,  garbage collector will clean up toBeDeleted. |   |   |   |
| contains(Object o)     | O(n) linear search                                                                                                              |   |   |   |
| insert(int index, E e) | O(n) get the node at index-1(prev) newNode.next = prev.next // the one currently at index prev.next = newNode                   |   |   |   |
| get(int index)         | O(n) linear search to the index                                                                                                 |   |   |   |
| remove(int index)      | O(n) get the node at index-1(prev) prev.next = prev.next.next                                                                   |   |   |   |

## Simple Linked List
Simple linked list, just hold a first (optional also a last) reference. And each node or link holds the data and the next link.

## Doubly Linked List
Each link additionally holds a reference of the previous link. This can make removal of links easier.

## Circular Linked List
Is a doubly linked list, where the last item contains link of the first element as next and the first element has a link to the last element as previous.

# Stack
LIFO = Last in first out, like a stack of books.
Functionality: push/add(add on top), pop/remove(remove top one), peek(look at the top one without removing)

# Queue
FIFO = First in first out, like a queue when waiting in line to pay.
Functionality: enqueue/add/offer(add to the back), dequeue/remove/poll(remove front one), peek/element(look at the front one)

# Queue using Stacks
There are 2 ways to implement this, either the enqueue operation will be costly or the dequeue operation. But the implementations are basically the same.
Hwowever you will in both cases need 2 stacks(Q1 and Q2).

Lets say we will make the dequeue costly:

## Enqueue
push() incoming data to Q1.
Here time complexity will be O(1)

## Dequeue
If Q2 is empty: then one by one pop() from Q1 and push() to Q2. (This will flip the order)
Pop() the element from Q2. Which will be the one that was at the bottom of the Q1, so the last added.
Here time complexity will be O(N)


# Stack using Queues
This is the opposite to the above, here we also will need to choose an operation to be costly and will be using 2 queues(Q1 and Q2).

Lets say we will make the push costly:

## Push
if Q1 is not empty: then one by one dequeue() from Q1 and enqueue() to Q2.
Enqueue() the new value to Q1.
Dequeue() from Q2 and enqueue to Q1 for all values.
Here time complexity will be O(n)

## Pop
Dequeue() an item from Q1 and return it.
Here time complexity will be O(1)

