public class Array {

    //基于Java数组，二次封装属于自己的数组类（动态数组）
    private int[] data;
    private int size;  //size为数组中有效元素个数，也指向数组中下一个没有元素的索引

    public Array(int capacity){    //构造函数，用户传进来capacity，即用户希望Array的length为capacity
        data = new int[capacity];
        size = 0;
    }

    //无参数的构造函数，默认数组的容量capacity=10
    public Array(){
        this( 10);
    }

    //获取数组中的元素个数
    public int getSize() {
        return size;
    }

    //获取数组的容量
    public int getCapacity(){
        return data.length;
    }

    //判断数组是否为空
    public boolean isEmpty(){
        return size==0;
    }

    //向所有元素后添加一个新的元素e
    public void addLast(int e){
        if (size == data.length){
            throw new IllegalArgumentException("AddLast failed. Array is full");
        }
        data[size] = e;
        size ++;
    }

    //在数组的第index个位置插入元素e   输入有两个 index和e
    public void add(int index, int e){
        if (size==data.length){
            throw new IllegalArgumentException("Add failed. Array is full");
        }
        if (index < 0 || index > size){
            throw new IllegalArgumentException("Add failed. Required index >=0 and index <= size.");
        }

        for (int i = size-1; i >= index; i--){
            data[i + 1] =  data[i];
        }
        data[index] = e;
        size ++;
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d , capacity = %d\n", size, data.length));
        res.append('[');
        for (int i = 0; i < size; i++){
            res.append(data[i]);
            if (i !=size-1){
                res.append(", ");
            }
        }
        res.append(']');
        return res.toString();
    }
}
