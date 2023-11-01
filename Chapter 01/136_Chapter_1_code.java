public class BinarySearch {

    /**
     * Binary search method to find the target element in a sorted array.
     *
     * @param arr    The sorted array to search in.
     * @param target The element to search for.
     * @return The index of the target element if found; otherwise, -1.
     */
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            // If the middle element is the target, return its index
            if (arr[mid] == target) {
                return mid;
            }
            // If the target is in the left half, discard the right half
            if (arr[mid] > target) {
                right = mid - 1;
            } else { // If the target is in the right half, discard the left half
                left = mid + 1;
            }
        }

        // If the target is not found, return -1
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {2, 5, 8, 12, 16, 23, 38, 45, 56, 72, 91};
        int target = 23;

        int index = binarySearch(arr, target);

        if (index != -1) {
            System.out.println("Element found at index: " + index);
        } else {
            System.out.println("Element not found in the array.");
        }
    }
}
