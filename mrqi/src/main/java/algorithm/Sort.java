package algorithm;

import java.util.Arrays;

/***
 * 排序算法
 */

public class Sort {


    /**
     *  计数排序
     */


    public  static  int [] ContSort(){

        int arr[] = {10,5,11,68,20,41,0,24,25,4,7,94,15,5,44,66};

         //1 获取数组中最大和最小的数
        int max =0;
        int min =0;

        for(int i=0; i<arr.length;i++){
            max = Math.max(max,arr[i]);
            min = Math.min(min,arr[i]);
        }

        //2.创建计数临时数组
        int [] temp =  new int [max-min +1];

        //3开始计数
        for (int i=0;i<arr.length;i++){
            temp[arr[i]-min]++;  //计数
        }

        //4.将计数数组中的数组放回原数组
        for (int i=0,index =0;i<temp.length;i++){
            int Item = temp[i];
            while (Item -- !=0){  //深度优先
                arr[index++] = i+min;
            }
        }
        System.out.println(Arrays.toString(arr));
        return  arr;
    }


}
