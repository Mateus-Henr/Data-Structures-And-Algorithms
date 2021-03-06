package tutorial;

/*  Heaps - Sort

    • We know that the root has the largest values, when dealing with heap.
    • Swap root with last element in the array.
    • Heapify the tree, but exclude the last node. In order words, we don't include the max value that was previously
      the root.
    • After heapify, the second-largest element is at the root.
    • Rinse and repeat until we hit one element.
    • This algorithm consists of grabbing the first value since we have a max heap, and pushing it to the end of the
      array, so on every step that we want a value we heapify the heap to get the next value, we keep it going until
      we have hit one element, meaning that all the values will be sorted.

    Example

    Initial heap for representation
                       [80]
                [75]           [60]
           [68]     [55]   [40]    [52]
       [67]

    Array = [80] [75] [60] [68] [55] [40] [52] [67] |


    Step 1 (swap root with last index)
                       [67]                     Last index = 7
                [75]           [60]
           [68]     [55]   [40]    [52]
       [80]

    Array = [67] [75] [60] [68] [55] [40] [52] [80] |

    Step 1 (heapify from root until last index)
                       [75]                     Last index = 6
                [68]           [60]
           [67]     [55]   [40]    [52]

    Array = [75] [68] [60] [67] [55] [40] [52] | [80]


    Step 2 (swap root with last index)
                       [52]                     Last index = 6
                [68]           [60]
           [67]     [55]   [40]    [75]

    Array = [52] [68] [60] [67] [55] [40] [75] | [80]

    Step 2 (heapify from root until last index))
                       [68]                     Last index = 5
                [67]           [60]
           [52]     [55]   [40]

    Array = [68] [67] [60] [52] [55] [40] | [75] [80]


    Step 3 (swap root with last index)
                       [40]                     Last index = 5
                [67]           [60]
           [52]     [55]   [68]

    Array = [40] [67] [60] [52] [55] [68] | [75] [80]

    Step 3 (heapify from root until last index))
                       [67]                     Last index = 4
                [55]           [60]
           [52]     [40]

    Array = [67] [55] [60] [52] [40] | [68] [75] [80]


    Step 4 (swap root with last index)
                       [40]                     Last index = 4
                [55]           [60]
           [52]     [67]

    Array = [40] [55] [60] [52] [67] | [68] [75] [80]

    Step 4 (heapify from root until last index))
                       [60]                     Last index = 3
                [55]           [40]
           [52]

    Array = [60] [55] [40] [52] | [67] [68] [75] [80]


    Step 5 (swap root with last index)
                       [52]                     Last index = 3
                [55]           [40]
           [60]

    Array = [52] [55] [40] [60] | [67] [68] [75] [80]

    Step 5 (heapify from root until last index))
                       [55]                     Last index = 2
                [52]           [40]

    Array = [55] [52] [40] | [60] [67] [68] [75] [80]


    Step 6 (swap root with last index)
                       [40]                     Last index = 2
                [52]           [52]

    Array = [30] [52] [52] | [60] [67] [68] [75] [80]

    Step 6 (heapify from root until last index))
                       [55]                     Last index = 1
                [52]

    Array = [55] [52] | [40] [60] [67] [68] [75] [80]


    Step 7 (swap root with last index)
                       [52]                     Last index = 1
                [55]

    Array = [52] [55] | [40] [60] [67] [68] [75] [80]

    Step 7 (heapify from root until last index))
                       [52]                     Last index = 0

    Array = [52] | [55] [40] [60] [67] [68] [75] [80]

    Now that we got to one element, we have sorted the heap.
    OBS: Whenever we heapified the heap, we heapify it looking down the heap since the root doesn't have any parent
         we have to check its children.

    Final array
        [52] [55] [40] [60] [67] [68] [75] [80]


    Final conclusion
    • In-place algorithm.
    • It has a time complexity is O(nlog(n)), this happens because we swap n elements, and then on each iteration of
      the loop, we also have to fix the heap, and this fixing is log(n).
    • If you have a heap, and you want to sort it, heapsort can be a decent sorting algorithm.
    • Keep in mind that once you sort the heap, it's no longer a heap. So if you want to keep using the heap you should
      not sort it.
    • If you want to apply the heapsort on the data, then you would have to build the heap first, and that would involve
      heapifying on each step so the time complexity would degrade, even so, doing that could be better than some O(n²)
      sorting algorithms.
 */

public class Main
{
    public static void main(String[] args)
    {
        Heap heap = new Heap(10);

        heap.insert(80);
        heap.insert(75);
        heap.insert(60);
        heap.insert(68);
        heap.insert(55);
        heap.insert(40);
        heap.insert(52);
        heap.insert(67);

        System.out.println("Printing the heap out");
        heap.printHeap();

        System.out.println("Printing sorted heap out");
        heap.sort();
        heap.printHeap();
    }

}