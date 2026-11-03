public class Main {
    public static void main(String[] args) {
        int[] nums = {-50, -12, 5, 16, 42, 55, 81, 108};

        int findValue = 16;
        int index = binarySearch(findValue, nums);

        if (index == -1) {
            System.out.println("Value " + findValue + " is not in the array");
        } else {
            System.out.println("Value " + findValue + " is found at index " + index);
        }

        findValue = 100;
        index = binarySearch(findValue, nums);

        if (index == -1) {
            System.out.println("Value " + findValue + " is not in the array");
        } else {
            System.out.println("Value " + findValue + " is found at index " + index);
        }

        //======================= QUIZ #5 =================

        findValue = -50;
        index = positiveNegativeSearch(findValue, nums);

        if (index == -1) {
            System.out.println("Value " + findValue + " is not in the array");
        } else {
            System.out.println("Value " + findValue + " is found at index " + index);
        }

    }

    private static int linearSearch(int value, int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == value) {
                return i;
            }
        }

        return -1;
    }

    private static int binarySearch(int value, int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int middle = (start + end) / 2;

            if (nums[middle] == value) {
                return middle;
            }

            if (nums[middle] > value) {
                // left half of the array
                end = middle - 1;
            } else {
                // right half of the array
                start = middle + 1;
            }
        }

        return -1;
    }

    private static int oddEvenSearch(int value, int[] nums) {
        // Sorted or unsorted? - Sorted
        // Steps:
        // 1) Search through the odd-number indices in the array
        // 2) Return the index if value is found
        // 3) Search through the even-number indices in the array
        // 4) Return the index if value is found
        // Time Complexity - O(n)

        // search odd number indices
        for (int i = 1; i < nums.length; i += 2) {
            if (nums[i] == value)
                return i;
        }

        // search even number indices
        for (int i = 0; i < nums.length; i += 2) {
            if (nums[i] == value)
                return i;
        }

        return -1;
    }

    //===============Quiz #5 ================
    private static int positiveNegativeSearch(int value, int[] nums) {
        // Sorted or unsorted? - unsorted
        // Steps:
        // 1. Check if the value is negative or positive or zero.
        // 2. If negative, search only negative numbers.
        // 3. If positive, search only positive numbers.
        // 4. If zero, search for zero in the array.
        // 5. Return the index if found, otherwise return -1.
        // Time Complexity - O(n)

        for (int i = 0; i < nums.length; i++) {

            // Search for negative numbers
            if (value < 0 && nums[i] < 0) {
                if (nums[i] == value) {
                    return i;
                }
            }

            // Search for positive numbers
            else if (value > 0 && nums[i] > 0) {
                if (nums[i] == value) {
                    return i;
                }
            }

            // Search if zero
            else if (value == 0 && nums[i] == 0) {
                return i;
            }
        }

        return -1;
    }


}