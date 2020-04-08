package ru.hw.random.benchmark;

import ru.hw.random.LCGRandom;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;

public class Benchmark {
    private static final int ITERATIONS = 1_000_000;
    private static final String FOLDER = "benchmarks/";
    private static final String FILE = FOLDER + "benchmark.txt";

    public static void main(String[] args) throws IOException {
        var res = createRandomArray();

        if (!Files.exists(Paths.get(FOLDER))) {
            Files.createDirectory(Paths.get(FOLDER));
        }

        Files.write(Paths.get(FILE), ("=".repeat(50) + "\n").getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        Files.write(Paths.get(FILE), (LocalDateTime.now().toString() + "\n").getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        Files.write(Paths.get(FILE), ("iterations: " + ITERATIONS + "\n").getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        Files.write(Paths.get(FILE), (res + "ns" + "\n").getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        Files.write(Paths.get(FILE), ("=".repeat(50) + "\n").getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
    }

    private static long createRandomArray() {
        double res = 0.0d;
        var begin = Instant.now();

        for (int i = 0; i < ITERATIONS; i++) {
            res = LCGRandom.next();
        }

        var duration = Duration.between(begin, Instant.now()).abs().toNanos() / ITERATIONS;
        System.out.println(res);
        return duration;
    }
}
