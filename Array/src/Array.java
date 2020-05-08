////1. 问题：为什么有的前缀是void，有的是int：void是一个方法，int是返回一个值，值为int
////2. 为什么在main函数中调用addLast之后能直接用toString

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

    //索取index位置的元素
    public int get(int index){
       if (index<0 || index>=size){
           throw new IllegalArgumentException("Get failed. Required index >=0 and index < size.");
       }
       return data[index];
    }

    //修改index位置的元素为e
    public void set(int index, int e){
        if (index<0 || index>=size){
            throw new IllegalArgumentException("Get failed. Required index >=0 and index < size.");
        }
        data[index] = e;
    }

    //查找数组中是否存在元素e
    public boolean contains(int e){
        for (int i=0; i<size; i++){
            if (data[i] == e){
                return true;
            }
        }
        return false;
    }

    //查找数组中元素e所在位置的index，若没有，则返回e
    public int findIndex(int e){
        for (int i=0; i<size; i++){
            if (data[i] == e){
                return i;
            }
        }
        return -1;
    }

    //删除index处的元素,返回被删除的元素具体值
    public int remove(int index){
        if (index<0 || index>=size){
            throw new IllegalArgumentException("Remove failed. Required index >=0 and index < size.");
        }
        int temp = data[index]; //先把data[index]存起来，不然删除之后data[index]就变了
        for (int i=index+1; i<size; i++){
            data[i-1] = data[i];
        }
        size--;
        return temp;
    }

    public int removeFirst(){
        return remove(0);
    }

    public int removeLast(){
        return remove(size-1);
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
