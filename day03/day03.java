package day03;

import utils.utils;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class day03 {
    final static String day = "03";

    public static void main(String[] args) {
        List<String> input = utils.readInput(day);
        AtomicInteger counter = new AtomicInteger();
        int total = input.stream()
            .collect(Collectors.groupingBy(s -> counter.getAndIncrement() / 3))
            .values()
            .stream()
            .mapToInt(s -> {
            List<String> commonCharacters = new ArrayList<>(Arrays.asList(s.get(0).split("")));
            commonCharacters.retainAll(new ArrayList<>(Arrays.asList(s.get(1).split(""))));
            commonCharacters.retainAll(new ArrayList<>(Arrays.asList(s.get(2).split(""))));
            
            char common = commonCharacters.get(0).charAt(0);
            return Character.isLowerCase(common) ? common - 'a' + 1 : common - 'A' + 27;
            }).sum();         

        System.out.println(total);
    }
}
