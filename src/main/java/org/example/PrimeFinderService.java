package org.example;

import java.util.ArrayList;
import java.util.List;

public class PrimeFinderService {
    public List<Integer> getAllPrimes(int lowerBound,int upperBound,int numThreads) throws InterruptedException {

        int range = (upperBound - lowerBound + 1) / numThreads;
        PrimeFinder[] threads = new PrimeFinder[numThreads];
        for (int i = 0; i < numThreads; i++) {
            int start = lowerBound + i * range;
            int end = (i == numThreads - 1) ? upperBound : start + range - 1;
            threads[i] = new PrimeFinder(start, end);
            threads[i].start();
        }

        List<Integer> allPrimes = new ArrayList<>();
        for (int i = 0; i < numThreads; i++) {
            threads[i].join();
            allPrimes.addAll(threads[i].getPrimes());
        }

        return allPrimes;
    }
}
