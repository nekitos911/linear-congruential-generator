package ru.hw.random;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;

import java.util.stream.IntStream;

public class TestRandomGenerator {
    private static final int COUNT = 100;
    @RepeatedTest(100)
    public void test() {
        var leftInclusive = 37;
        var rightExclusive = COUNT;

        var randoms = IntStream.range(0, COUNT)
                .map(i -> leftInclusive + ((int)((rightExclusive - leftInclusive) * LCGRandom.next())))
                .sorted().toArray();

        Assertions.assertTrue(randoms[0] >= leftInclusive && randoms[randoms.length - 1] < rightExclusive);
    }
}
