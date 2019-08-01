package com.mshz.shorts;

/**
 * @desc: -.
 * @Author: lipei
 * @CreateDate: 2019/7/30 10:05
 * @Version: 1.0
 */

public class BubbleShort {
    private static   int[] arr={100,5,2,99,7,3,4,0,20};

    public static void main(String[] args) {
   //  bubleShort(arr);
       aa(arr);
         for (int arg : arr) {
            System.out.println(arg);
        }
    }

    public  static  void  bubleShort(int[] arr){
        int c=0;
         for (int i=0;i<arr.length;i++){
            for (int j=i;j<arr.length;j++){
                if(arr[i]>arr[j]){
                    c++;
                    int temp = arr[j];
                     arr[j]=arr[i];
                    arr[i]=temp;
                }

            }
         }
        System.out.println(c);
    }

    public static void aa(int[] arr){
        int c=0;
        for(int i=0;i<arr.length-1;i++) {
            for(int j=0;j<arr.length-i-1;j++) {
                if(arr[j]>arr[j+1]) {
                    c++;
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
        System.out.println(c);
    }
}
