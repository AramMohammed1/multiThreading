package org.example;

import java.util.ArrayList;
import java.util.List;

public class PrimeFinder extends Thread {
    private int start, end;
    private List<Integer> primes = new ArrayList<>();

    public PrimeFinder(int start, int end) {
        this.start = start;
        this.end = end;
    }

    private boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    @Override
    public void run() {
        for (int i = start; i <= end; i++) {
            if (isPrime(i)) {
                primes.add(i);
            }
        }
    }

    public List<Integer> getPrimes() {
        return primes;
    }
}

