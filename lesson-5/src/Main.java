public class Main {
    private static final int SIZE = 10_000_000;
    private static final int h = SIZE / 2;
    private static float[] arr1 = new float[SIZE];

    public static void main(String[] args){
        fillArr(arr1);
        calcArr(arr1);

        fillArr(arr1);
        calcArrThread(arr1);
    }
    private static void calcArr(float[] arr){
        long a = System.currentTimeMillis();
        for(int i = 0; i<arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println("первый метод работал " + (System.currentTimeMillis() - a) + " мс");
    }
    private static void fillArr(float[] arr){
        for(int i = 0; i<arr.length; i++){
            arr[i] = 1f;
        }
    }
    private static void calcArrThread(float[] arr){
        long a = System.currentTimeMillis();
        float[] a1 = new float[h];
        float[] a2 = new float[h];
        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);

        MethodTwoThread oneThread = new MethodTwoThread(a1,0);
        MethodTwoThread twoThread = new MethodTwoThread(a2,h);
        System.out.println("\nмассив был разбит на 2 за " + (System.currentTimeMillis() - a) + " мс");
        long b = System.currentTimeMillis();
        try {
            oneThread.join();
            twoThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("просчет каждого из 2 массивов " + (System.currentTimeMillis() - b) + " мс");
        b = System.currentTimeMillis();
        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);
        System.out.println("склейка " + (System.currentTimeMillis() - b) + " мс");
        System.out.println("второй метод работал " + (System.currentTimeMillis() - a) + " мс");
    }
}
