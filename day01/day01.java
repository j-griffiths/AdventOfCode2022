package day01;

import utils.utils;
import java.util.List;
import java.util.Comparator;

public class day01 {
    final static String day = "01";

    public static void main(String[] args) {
        List<List<String>> inputParts = utils.splitInput(utils.readInput(day));
        
        int total = inputParts.stream()
            .map(part -> part.stream().mapToInt(x -> Integer.parseInt(x)).sum()).sorted(Comparator.reverseOrder()).limit(3).mapToInt(x -> x).sum();

        System.out.println(total);
    }
}
