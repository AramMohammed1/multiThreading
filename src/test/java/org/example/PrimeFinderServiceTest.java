package org.example;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrimeFinderServiceTest extends TestCase {



    public void testGetAllPrimes() throws InterruptedException {
        long StartTime= System.currentTimeMillis();
        PrimeFinderService primeFinderService = new PrimeFinderService();
        List<Integer> primes= primeFinderService.getAllPrimes(1,10000000,1);
        long end = System.currentTimeMillis()- StartTime;
        System.out.println("Time Taken: "+ end);
    }

    public void testGetAllPrimesNumThreads() throws InterruptedException {
        PrimeFinderService primeFinderService = new PrimeFinderService();
        List<Integer> numThreads = Arrays.asList(1,2,4,8,16,32,64,128);
        for(int numThread:numThreads){
            long StartTime= System.currentTimeMillis();
            List<Integer> primes= primeFinderService.getAllPrimes(1,100000000,numThread);
            long end = System.currentTimeMillis()- StartTime;
            System.out.println(numThread+"    "+end);
        }
    }
}