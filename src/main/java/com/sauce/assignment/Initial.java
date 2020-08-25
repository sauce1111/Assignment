package com.sauce.assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Initial {

    //1. 초성 = 19자
    //2. 중성자 = 21 자
    //3. 종성 = 27 자

    private static final int HANGEUL_START_CODE = 0xAC00;
    private static final int HANGEUL_END_CODE = 0xD7AF;
    private static final int CHO_BASE = 0x1100;
    private static final int JA_BASE = 0x3131;
    private static final int MO_BASE = 0x314F;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("한글 문장을 입력해 주세요.");
        String inputText = input.nextLine();
        List<Character> charList = splitInitial(inputText);
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : charList) {
            stringBuilder.append(c);
        }
        System.out.println(stringBuilder.toString());
    }

    public static List<Character> splitInitial(String inputText) {
        List<Character> list = new ArrayList<>();
        for(char c : inputText.toCharArray()) {
            if(c <= 10 || c == 32) {
                list.add(c);
            } else if (c >= JA_BASE && c <= JA_BASE + 36) {
                list.add(c);
            } else if (c >= MO_BASE && c <= MO_BASE + 58) {
                list.add((char)0);
            } else if (c >= HANGEUL_START_CODE && c <= HANGEUL_END_CODE) {
                int choInt = (c - HANGEUL_START_CODE) / 28 / 21;
                char cho = (char) (choInt + CHO_BASE);
                list.add(cho);
            } else {
                list.add(c);
            }
        }
        return list;
    }
}
