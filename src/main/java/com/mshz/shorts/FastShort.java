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
    private static int[] arr = {5, 7, 1, 8, 4};
    private static volatile int temp = 0;

    public static void main(String[] args) {
        int[] ints = sortQuick(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(ints));
    }
    /*https://m.wang1314.com/doc/webapp/topic/14435820.html*/

    public static int[] sortQuick(int[] in, int left, int right){
        int key = in[left]; //选定数组第一个数字作为key
        int start = left;
        int end = right;
        while(start<end){
            //从右向左遍历,找到小于key的,放入下标strat中。
            while(start < end && key<=in[end]){
                end--;
            }
            in[start] = in[end];

            //从左向右遍历,找到大于key的,放入下标end中。
            while(start < end && key > in[start]){
                start++;
            }
            in[end] = in[start];
        }
        //此时start==end,这就是所谓的轴，把key放入轴中，轴左边的都<key,轴右边的都>key
        in[start] = key;
        //此时大家想象一下，轴在数组中间，说明把数组分成两部分，此时要对这两部分分别进行快排。
        if(start>left)sortQuick(in,left,start-1);
        if(end<right)sortQuick(in, end+1, right);
        return in;
    }
}
