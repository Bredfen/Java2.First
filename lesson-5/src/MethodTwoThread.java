public class MethodTwoThread extends Thread{
    private static float[] arr;
    private static int add;

    MethodTwoThread(float[] arr, int add){
        this.arr = arr;
        this.add = add;
        start();
    }

    @Override
    public void run(){
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + (i + add) / 5) * Math.cos(0.2f + (i + add) / 5) * Math.cos(0.4f + (i + add) / 2));
        }
    }
}