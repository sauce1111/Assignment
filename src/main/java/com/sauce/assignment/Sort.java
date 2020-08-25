package com.sauce.assignment;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Sort {

    public static void main(String[] args) {
        Scanner input1 = new Scanner(System.in);
        Scanner input2 = new Scanner(System.in);

        System.out.println("정렬할 배열의 크기를 입력하세요. (2 이상)");

        Integer [] intArr = new Integer[input1.nextInt()];

        System.out.println("정렬할 정수를 띄어쓰기로 구분하여 입력해 주세요.");

        for (int i = 0; i < intArr.length; i++) {
            intArr[i] = Integer.parseInt(input2.next());
        }
        Arrays.stream(intArr)
            .sorted(Comparator.reverseOrder())
            .forEach(System.out::print);
    }
}
