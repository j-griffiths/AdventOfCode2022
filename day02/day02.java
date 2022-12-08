package day02;

import utils.utils;
import java.util.List;

public class day02 {
    final static String day = "02";

    public static void main(String[] args) {
        List<String> input = utils.readInput(day);
        int total = input.stream()
            .map(s -> s.replaceAll("A", "1"))
            .map(s -> s.replaceAll("B", "2"))
            .map(s -> s.replaceAll("C|Y", "3"))
            .map(s -> s.replaceAll("X", "0"))
            .map(s -> s.replaceAll("Z", "6"))
            .mapToInt(s ->  Integer.parseInt(s.substring(2,3)) + getPlay(s))
            .sum();

        System.out.println(total);
    }

    private static int getResult(String input) {
        int player1 = Integer.parseInt(input.substring(0, 1));
        int player2 = Integer.parseInt(input.substring(2, 3));

        if (player1 == player2) {
            return 3;
        } else if (player1 % 3 == player2 - 1) {
            return 6;
        } else {
            return 0;
        }
    }

    private static int getPlay(String input) {
        int player1 = Integer.parseInt(input.substring(0, 1));
        int result = Integer.parseInt(input.substring(2, 3));

        if (result == 3) {
            return player1;
        } else if (result == 6) {
            return player1 % 3 + 1;
        } else {
            return (player1 + 1) % 3 + 1;
        }
    }
}
