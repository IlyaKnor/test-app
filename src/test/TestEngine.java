package test;

import main.Engine;
import main.Intersection;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestEngine {
    @Test
    public void correctIntersection() {
        Engine engine = new Engine();
        List<String> firstList = new ArrayList<>();
        firstList.add("гвоздь");
        firstList.add("шуруп");
        firstList.add("краска синяя");
        firstList.add("ведро для воды");
        List<String> secondList = new ArrayList<>();
        secondList.add("краска");
        secondList.add("корыто для воды");
        secondList.add("шуруп 321");
        List<Intersection> intersections = engine.map(firstList, secondList);

        Assert.assertSame("гвоздь", intersections.get(0).getWord());
        Assert.assertSame("шуруп", intersections.get(1).getWord());
        Assert.assertSame("шуруп 321", intersections.get(1).getIntersections().get(0));
        Assert.assertSame("краска синяя", intersections.get(2).getWord());
        Assert.assertSame("краска", intersections.get(2).getIntersections().get(0));
        Assert.assertSame("ведро для воды", intersections.get(3).getWord());
        Assert.assertSame("корыто для воды", intersections.get(3).getIntersections().get(0));
    }

    @Test
    public void correctWithDifferentLetterCase() {
        Engine engine = new Engine();
        List<String> firstList = new ArrayList<>();
        firstList.add("ШуруП");
        List<String> secondList = new ArrayList<>();
        secondList.add("шуруп 321");
        List<Intersection> intersections = engine.map(firstList, secondList);

        Assert.assertSame("ШуруП", intersections.get(0).getWord());
        Assert.assertSame("шуруп 321", intersections.get(0).getIntersections().get(0));
    }

    @Test
    public void correctWithManyIntersection() {
        Engine engine = new Engine();
        List<String> firstList = new ArrayList<>();
        firstList.add("ШуруП");
        List<String> secondList = new ArrayList<>();
        secondList.add("шуруп 321");
        secondList.add("шуруп 84874");
        List<Intersection> intersections = engine.map(firstList, secondList);

        Assert.assertSame("ШуруП", intersections.get(0).getWord());
        Assert.assertSame("шуруп 321", intersections.get(0).getIntersections().get(0));
        Assert.assertSame("шуруп 84874", intersections.get(0).getIntersections().get(1));
    }

    @Test
    public void correctIntersectionForManyWords() {
        Engine engine = new Engine();
        List<String> firstList = new ArrayList<>();
        firstList.add("Краска красная");
        firstList.add("новая краска");
        List<String> secondList = new ArrayList<>();
        secondList.add("краска");
        List<Intersection> intersections = engine.map(firstList, secondList);

        Assert.assertSame("Краска красная", intersections.get(0).getWord());
        Assert.assertSame("краска", intersections.get(0).getIntersections().get(0));
        Assert.assertSame("новая краска", intersections.get(1).getWord());
        Assert.assertSame("краска", intersections.get(1).getIntersections().get(0));
    }
}
