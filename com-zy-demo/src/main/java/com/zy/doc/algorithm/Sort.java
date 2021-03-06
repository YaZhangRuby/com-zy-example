package com.zy.doc.algorithm;

/**
 * Author: zhangya
 * Date: 2019/3/28
 * Time: 13:26
 * Description:
 */
public class Sort {

    public static void main(String[] args) {
        int[] a = {8,2,6,12,1,9,5,5,10};
        quickSort(a, 0, 8);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    /**
     * 快速排序
     */
    private static void quickSort(int[] a, int low, int height) {
        int i = low;
        int j = height;
        //防止越界
        if (i > j) return;
        int base = a[low];
        while (i != j) {
            while (a[j] >= base && i < j) {
                j--;
            }
            while (a[i] <= base && i < j) {
                i++;
            }
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
        base = a[low];
        a[low] = a[i];
        a[i] = base;

        quickSort(a, low, i-1);
        quickSort(a,i+1, height);
    }

    //二分法查找
    public int binarySearch(int[] arr, int key) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int low = 0;
        int height = arr.length - 1;
        while (low <= height) {
            int middle = (low + height) / 2;
            if (key > arr[middle]) {
                low = middle + 1;
            } else if (key < arr[middle]) {
                height = middle - 1;
            } else {
                return middle;
            }
        }
        return  -1;
    }
}
