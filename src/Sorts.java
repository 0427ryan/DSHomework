
import java.util.function.BiFunction;
import java.util.List;
import java.util.LinkedList;

public class Sorts {

    public Sorts() {

    }

    public static<T> void quickSort(List<T> list, int front, int back, BiFunction<T, T, Boolean> o) {
        if(back - front < 1) {
            return;
        }

        int midIndex = (front + back) / 2;
        int begin = front, end = back;

        T temp = list.get(front + 1);
        list.set(front + 1, list.get(midIndex));
        list.set(midIndex, temp);
        midIndex = front + 1;

        while(front < back) {
            if(o.apply(list.get(front), list.get(midIndex))) {
                if(front < back - 1) {
                    temp = list.get(midIndex);
                    list.set(midIndex, list.get(midIndex + 1));
                    list.set(midIndex + 1, temp);
                    midIndex++;
                }
                front++;
            } else {
                temp = list.get(back);
                list.set(back, list.get(front));
                list.set(front, temp);
                back--;
            }
        }

        quickSort(list, begin, front, o);
        quickSort(list, back + 1, end, o);
    }
    public static<T> void quickSort(List<T> list, BiFunction<T, T, Boolean> o) {
        quickSort(list, 0, list.size() - 1, o);
    }

    public static<T> void insertionSort(List<T> list, BiFunction<T, T, Boolean> o) {
        for(int i = 0 ; i < list.size() ; i++) {
            for(int j = 0 ; j < i ; j++) {
                if(o.apply(list.get(i), list.get(j))) {
                    T temp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, temp);
                }
            }
        }
    }

    private static <T> void merge(List<T> list, int index1, int index2, int index3, BiFunction<T, T, Boolean> o) {
        List<T> temp = new LinkedList<>();
        int tempIndex1 = index1;
        int tempIndex2 = index2;

        while(tempIndex1 < index2 && tempIndex2 < index3) {
            if(o.apply(list.get(tempIndex1), list.get(tempIndex2))) {
                temp.add(list.get(tempIndex1));
                tempIndex1++;
            } else {
                temp.add(list.get(tempIndex2));
                tempIndex2++;
            }


        }
        if(tempIndex1 < index2) {
            temp.addAll(list.subList(tempIndex1, index2));
        }
        for(int i = 0 ; i < temp.size() ; i++) {
            list.set(index1 + i, temp.get(i));
        }
    }

    private static<T> void mergeSort2(List<T> list, int a, int b, BiFunction<T, T, Boolean> o) {
        if(b - a <= 1) {
            return;
        }

        mergeSort2(list, a, (b + a) / 2, o);
        mergeSort2(list, (b + a) / 2, b, o);
        merge(list, a, (b + a) / 2, b, o);
    }

    public static<T> void mergeSort(List<T> arr, BiFunction<T, T, Boolean> o) {
        mergeSort2(arr, 0, arr.size(), o);
    }


    public static<T> void heapSort(List<T> list, BiFunction<T, T, Boolean> o) {
        for(int i = list.size() - 1 ; i >= 0 ; i--) {
            heapify(list, i, list.size() - 1, o);
        }

        list.forEach(System.out::println);

        for(int i = list.size() - 1 ; i >= 0 ; ) {
            T temp = list.get(0);
            list.set(0, list.get(i));
            list.set(i, temp);
            i--;
            heapify(list, 0, i, o);
        }
    }

    private static int getParent(int current) {
        return (current + 1) / 2 - 1;
    }

    private static int getLeftChild(int current) {
        return current * 2 + 1;
    }

    private static <T> void heapify(List<T> list, int current, int tail, BiFunction<T, T, Boolean> o) {

        if(getLeftChild(current) > tail) {
            return;
        }

        if( getLeftChild(current) == tail) {
            if(o.apply(list.get(current), list.get(getLeftChild(current)))) {
                T temp = list.get(current);
                list.set(current, list.get(getLeftChild(current)));
                list.set(getLeftChild(current), temp);
            }
            return;
        }


        if(o.apply(list.get(getLeftChild(current)), list.get(current)) && o.apply(list.get(getLeftChild(current) + 1), list.get(current))) {
            return;
        }

        if( o.apply(list.get(getLeftChild(current)), list.get(getLeftChild(current) + 1)) ) {
            T temp = list.get(current);
            list.set(current, list.get(getLeftChild(current) + 1));
            list.set(getLeftChild(current) + 1, temp);
            heapify(list, getLeftChild(current) + 1, tail, o);
        } else {
            T temp = list.get(current);
            list.set(current, list.get(getLeftChild(current)));
            list.set(getLeftChild(current), temp);
            heapify(list, getLeftChild(current), tail, o);
        }
    }

}