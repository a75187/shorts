package com.mshz.shorts;

import java.util.Arrays;
import java.util.List;

/**
 * @desc: -.
 * @Author: lipei
 * @CreateDate: 2019/7/30 10:58
 * @Version: 1.0
 */

public class FastShort {
    private static int[] arr = {1, 2, 3};
    private static volatile int temp = 0;

    public static void main(String[] args) {
     //  int[] ints = sortQuick(arr, 0, arr.length - 1);
      // System.out.println(Arrays.toString(ints));
       myShort(arr, 0, arr.length - 1);
    }
    /*https://m.wang1314.com/doc/webapp/topic/14435820.html*/

    public static int[] sortQuick(int[] in, int left, int right) {
        int key = in[left]; //选定数组第一个数字作为key
        System.out.println(key);
        int start = left;
        int end = right;
        while (start < end) {
            //开始小于结束 且 从右向左遍历,找到小于key的,放入下标strat中。
            while (start < end && key <= in[end]) {
                end--;
            }
            System.out.println("尾部交换" + start + ":" + end);
            in[start] = in[end];
            System.out.println(Arrays.toString(in));
            //开始小于结束 且从左向右遍历,找到大于key的,放入下标end中。
            while (start < end && key > in[start]) {
                start++;
            }
            System.out.println("头部交换" + start + ":" + end);
            in[end] = in[start];
            System.out.println(Arrays.toString(in));
        }
        //此时start==end,这就是所谓的轴，把key放入轴中，轴左边的都<key,轴右边的都>key
        in[start] = key;

        //此时大家想象一下，轴在数组中间，说明把数组分成两部分，此时要对这基准数的两部分分别进行快排。
        if (start > left) {
            sortQuick(in, left, start - 1);
        }
        if (end < right) {
            sortQuick(in, end + 1, right);
        }
        return in;
    }

    public static void  myShort(int[] arr, int first, int tail) {
        int first_ = first;
        int tail_ = tail;
        int point=arr[first];
        //tip1 总的就是尾头->头尾->一直比较到头尾的下标相等中间值插入 ->完成成一次排序 找出了中间的数
        //tip2  递归 : 将上面完成循环的数组 一分为二以当次次结果point所在最后的角标为分割线 切割数组排序 相当于每次完成一次切割,就确定了一个中间数
        // 递归执行的次数 就是数组的大小-1 每次完成一个大的while循环就确定一个数的位置9699
        while (first_<tail_){
            /*从尾部找出比基数小于等于的*/
            while (first_<tail_ && arr[tail_]>=point){
                tail_--;
            }
            arr[first_]=arr[tail_];
            while (first_<tail_ && arr[first_]<point){
                first_++;
            }
            arr[tail_]=arr[first_];
        }
        arr[tail_]=point;
        System.out.println(Arrays.toString(arr));

  //此时大家想象一下，轴在数组中间，说明把数组分成两部分，此时要对这基准数的两部分分别进行快排。
        if (first_>first) {
            myShort(arr, first, first_ - 1);
        }
        if (tail_ < tail) {
            myShort(arr, tail_ + 1, tail);
        }
        System.out.println(Arrays.toString(arr));
    }

}
