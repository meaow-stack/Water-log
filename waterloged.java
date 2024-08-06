import java.util.Scanner;

class WaterLogged {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int[] height = { 1, 0, 2, 0, 1, 2, 0 };
            int n = height.length;
            int trap = trappedTheWater(height, n);
            System.out.println("The water trapped is: " + trap);
        }
    }

    public static int trappedTheWater(int[] height, int n) {
        int left = 0, right = n - 1;
        int waterTrap = 0;
        int leftMax = 0;
        int rightMax = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] > leftMax)
                    leftMax = height[left];
                else
                    waterTrap += leftMax - height[left];
                left++;
            } else {
                if (height[right] > rightMax)
                    rightMax = height[right];
                else
                    waterTrap += rightMax - height[right];
                right--;
            }
        }

        return waterTrap;
    }
}
