package com.sauce.assignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FindAndCombine {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("숫자가 포함된 문자열을 입력하세요");
        IntStream stream = input.nextLine().chars();
        String intStr = stream.filter((ch)-> (48 <= ch && ch <= 57))
            .mapToObj(ch -> (char)ch)
            .map(Object::toString)
            .collect(Collectors.joining(","));
        int[] intArr = Arrays.stream(intStr.split(",")).mapToInt(Integer::parseInt).toArray();
        int targetNum = 10;
        int cnt = 0;
        for (int i = 0; i < (1<<intArr.length); i++) {
            int tmp = 0;
            ArrayList<Integer> sub = new ArrayList<>();
            for (int j = 0; j < intArr.length; j++) {
                if((i&(1<<j)) != 0) {
                    tmp += intArr[j];
                    sub.add(intArr[j]);
                }
            }
            if(tmp == targetNum) {
                cnt++;
            }
        }
        System.out.println(cnt + "개");
    }
}
