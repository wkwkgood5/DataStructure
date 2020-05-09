public class Main {

    public static void main(String[] args) {
	    int[] arr = new int[10];//创建一个int数组，名字叫arr，然后需要new一个空间，写出这个数组的长度
	    for(int i=0; i<arr.length; i++){
            arr[i]=i;
        }

        int scores[] = new int[]{100,99,66};
	    for(int i=0;i<scores.length; i++){
	        System.out.println(scores[i]);
        }
        for(int score: scores){   //将scores里面每一个元素都叫做score，然后将score打印出来，得到和上面打印的相同效果
            System.out.println(score);
        }

        Array array = new Array(20); //这里的Array就用到了写的Array class
        for (int i=0; i<9; i++){
            array.addLast(i);
        }
        System.out.println(array);

        array.add(1, 100);
        System.out.println(array);

        array.remove(2);
        System.out.println(array);

        array.removeElement(100);
        System.out.println(array);
    }
}
