# Bag (Multiset)
A Bag can contain the same value multiple times. 

# Set
Compared to a bag, a set can only contain each value once. Meaning when adding a new element to the set there needs
to be an initial check to see if the value is already contained in the set. It is just like a mathematical set.

# Sorted Bag and Set
When adding the condition, that the data structure needs to be sorted it adds an extra layer of complexity.

To keep the bag and set sorted when adding or removing elements we need to shift the the array correspondingly.

If a data structure is sorted it allows us to make make searches faster by using a binary search instead of a
linear search.

# Time Complexities

| **Operation**          | **UnsortedBag**                           | **SortedBag**                                     | **UnsortedSet**                                | **SortedSet**                                                |
|------------------------|-------------------------------------------|---------------------------------------------------|------------------------------------------------|--------------------------------------------------------------|
| *add(E e)*             | **O(1)** just add to the end                  | **O(n)** Add O(1) + shift right O(n)                  | **O(n)** linear search O(n) + adding O(1)          | **O(n)** binary search O(log n) + adding O(1) + shift right O(n) |
| *contains(Object o)*   | **O(n)** linear search                        | **O(log n)** binary search                            | **O(n)** linear search                             | **O(log n)** binary search                                       |
| *remove(Object o)*     | **O(n)** linear search O(n) + adding O(1)     | **O(n)** binary search O(log n) + shift left O(n)     | **O(n)** linear search O(n) + adding O(1)          | **O(n)**  binary search O(log n) + shift left O(n)               |
| *Best use-case*        | When mainly adding a lot                  | When doing a lot of searches                      | Needs to be a set and order doesn't matter     | Needs to be a set and order does matter                      |
