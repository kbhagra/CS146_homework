public class assignment3 {

    // Calculates total water trapped between elevation bars
    public static int trapRainWater(int[] height) {
        int n = height.length;
        if (n == 0)
            return 0;

        // Arrays to store highest bar seen so far from left and right
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        // Build leftMax array
        // leftMax[i] = tallest bar from index 0 → i
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        // Build rightMax array
        // rightMax[i] = tallest bar from index i → n-1
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        int water = 0;

        // Water at each index = min(left wall, right wall) - height
        for (int i = 0; i < n; i++) {
            water += Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        return water;
    }

    public static void main(String[] args) {

        // Example elevation map
        int[] elevation = { 1, 2, 1, 4, 1, 2, 1, 5, 0, 0, 2, 1, 5 };

        int result = trapRainWater(elevation);

        // Output total trapped water
        System.out.println("Water Trapped: " + result + " units");
    }
}
