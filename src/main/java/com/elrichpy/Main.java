package com.elrichpy;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");

    }
    public int[] runningSum(int[] nums) {
        int[] arr = new int[nums.length];

        for(int i = 0; i < nums.length; i++) {
            if (i == 0) {
                arr[i] = nums[i];
            } else {
                arr[i] = arr[i] + nums[i];
            }

        }
        return arr;
    }
}