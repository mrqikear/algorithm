package leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class leetcode20200904 {



    @Test
    public void solutionTosum(){
        int [] nums  = {2, 7, 11, 15};
        int target = 9;
       int[] res = twoSum(nums,target);
        System.out.println(Arrays.toString(res));
    }
    /**
     * 给定 nums = [2, 7, 11, 15], target = 9
     *
     * 因为 nums[0] + nums[1] = 2 + 7 = 9
     * 所以返回 [0, 1]
     * https://leetcode-cn.com/classic/problems/two-sum/description/
     */
    public int[] twoSum(int[] nums, int target) {

        if (nums.length < 2) return  null;
        for(int i=0;i<nums.length;i++){
            for(int j = i+1; j<nums.length;j++){
                if(nums[i] + nums[j] == target){
                    return  new int[] {i,j};
                }
            }
        }
        return  null;
    }


    /**
     * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
     *
     * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
     *
     * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     *
     * 示例：
     *
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 0 -> 8
     * 原因：342 + 465 = 807
     */

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }

    }


    @Test
    public void solutionaddTwoNumbers(){
        ListNode listNode1 = new ListNode(9);
        ListNode listNode21 = new ListNode(1);
        ListNode listNode22 = new ListNode(9);
        ListNode listNode23 = new ListNode(9);
        ListNode listNode24 = new ListNode(9);
        ListNode listNode25 = new ListNode(9);
        ListNode listNode26 = new ListNode(9);
        ListNode listNode27 = new ListNode(9);
        listNode21.next = listNode22;
        listNode22.next = listNode23;
        listNode23.next = listNode24;
        listNode24.next = listNode25;
        listNode25.next = listNode26;
        listNode26.next = listNode27;

        addTwoNumbers(listNode1,listNode21);
    }



    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int index = 0;
        ListNode root = new ListNode(0);
        ListNode temp = root;
        while (l1 != null || l2 != null || index != 0) {  //这里加上index != 0 是为了解决当  l1 = {5},l2={5}的特殊情况。此时l1、l2都为null ,但是index = 1，需要进位。
            int l1val = l1!=null?l1.val:0;  //长度不一致时的情况。
            int l2val = l2!=null?l2.val:0;
            int add = l1val + l2val + index;
            if (add < 10)
            {
                temp.next = new ListNode(add);
                index =0;
            }
            else {
                temp.next = new ListNode(add % 10);
                index = 1;
            }
            temp = temp.next;
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }
        return root.next;

    }


    /**
     * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
     */


    @Test
    public  void stringLeng(){

        lengthOfLongestSubstring("abcbdef");
    }


    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        System.out.println(ans);
        return ans;
    }






}
