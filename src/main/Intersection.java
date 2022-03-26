package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Intersection {
    private String word;
    private List<String> intersections;

    @Override
    public int hashCode() {
        return Objects.hash(word, intersections);
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public List<String> getIntersections() {
        return intersections;
    }

    public void setIntersections(List<String> intersections) {
        this.intersections = intersections;
    }

    public Intersection(String word, List<String> intersections) {
        this.word = word;
        this.intersections = intersections;
    }

    public Intersection() {
    }

    public void add(String intersection) {
        if (this.intersections == null) {
            this.intersections = new ArrayList<>();
        }
        this.intersections.add(intersection);
    }
}
