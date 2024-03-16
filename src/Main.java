public class Main {
    public static void main(String[] args) {
        int[] numbers = {1, 3, 5, 6, 2, 7, 8, 0, 4, 3, 9, 2, 8, 1, 0, 5, 7, 4, 6, 9, 3, 2, 1, 8, 4, 0, 6, 7, 9, 5, 3, 2, 1, 0, 8, 4, 6, 7, 9, 5, 3, 2, 1, 0, 8, 4, 6, 7, 9, 5, 3, 2, 1, 0, 8, 4, 6, 7, 9, 5, 3, 2, 1, 0, 8, 4, 6, 7, 9, 5, 3, 2, 1, 0};

        // Tạo và start luồng tính tổng
        Thread sumThread = new Thread(new SumThread(array));
        sumThread.start();

        // Tạo và start luồng tìm max
        Thread maxThread = new Thread(new MaxThread(array));
        maxThread.start();
    }

    // Luồng tính tổng
    static class SumThread implements Runnable {
        private int[] array;

        public SumThread(int[] array) {
            this.array = array;
        }
 
        @Override
        public void run() {
            int sum = 0;
            for (int num : array) {
                sum += num;
            }
            System.out.println("Tổng các phần tử trong mảng: " + sum);
        }
    }

    // Luồng tìm max
    static class MaxThread implements Runnable {
        private int[] array;

        public MaxThread(int[] array) {
            this.array = array;
        }

        @Override
        public void run() {
            int max = array[0];
            for (int i = 1; i < array.length; i++) {
                if (array[i] > max) {
                    max = array[i];
                }
            }
            System.out.println("Phần tử lớn nhất trong mảng: " + max);
        }
    }
}
