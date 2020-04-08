package ru.hw.random;

public class LCGRandom {

    public static double next() {
        seed = (seed * a + c) % m;
        return (double)seed / MAX_SEED;
    }

    // GCC standard
    private static final long a = 1103515245L;
    private static final long c = 12345L;
    private static final long m = 1L << 32;
    private static final long MAX_SEED = m - 1;
    private static long seed = System.currentTimeMillis() % MAX_SEED;
}