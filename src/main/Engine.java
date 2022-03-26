package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Engine {

    public List<String> createListOfWords() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> strings = new ArrayList<>();
        System.out.println("Введите число");
        int count = Integer.parseInt(reader.readLine());
        if (count > 0) {
            int counter = 0;

            while (counter < count) {
                System.out.println("Введите строку");
                strings.add(reader.readLine());
                counter++;
            }
            return strings;
        }
        else {
            throw new Exception("Введите число больше 0");
        }
    }


    public List<Intersection> map(List<String> first, List<String> second) {
        return first.stream()
                .map(element -> findIntersections(element, second))
                .collect(Collectors.toList());
    }

    private Intersection findIntersections(String searching, List<String> lines) {
        Intersection intersection = new Intersection();
        intersection.setWord(searching);
        lines.forEach(line -> {
            if (contains(searching, line)) {
                intersection.add(line);
            }
        });
        return intersection;
    }

    private boolean contains(String searching, String line) {
        List<String> split = Arrays.asList(line.toLowerCase().split(" "));
        return Arrays.stream(searching.toLowerCase().split(" ")).anyMatch(split::contains);
    }

    public void print(List<Intersection> intersections) {
        for (Intersection intersection : intersections) {
            if (intersection.getIntersections() == null) {
                System.out.println(intersection.getWord() + ":?");
            } else {
                System.out.println(intersection.getWord() + ":" + intersection.getIntersections());
            }
        }
    }
}
