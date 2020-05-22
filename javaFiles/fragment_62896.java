package com.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Producers produce results. I do not care what their actual type is, but the
 * values in the map have to be comparable amongst themselves.
 */
interface IProducer<T extends Comparable<T>> {
    public Map<Integer, T> getResults();
}

/**
 * This example implementation ranks items in the map by using Strings.
 */
class ProducerA implements IProducer<String> {
    @Override
    public Map<Integer, String> getResults() {
        Map<Integer, String> result = new HashMap<Integer, String>();
        result.put(1, "A");
        result.put(2, "B");
        result.put(3, "B");

        return result;
    }
}

/**
 * This example implementation ranks items in the map by using integers.
 */
class ProducerB implements IProducer<Integer> {
    @Override
    public Map<Integer, Integer> getResults() {
        Map<Integer, Integer> result = new HashMap<Integer, Integer>();
        result.put(1, 10);
        result.put(2, 30);
        result.put(3, 30);

        return result;
    }
}

/**
 * Evaluator evaluates the results against the given groundTruth. All it needs
 * to know about results, is that they are comparable amongst themselves.
 */
interface IEvaluator {
    public <T extends Comparable<T>> double evaluate(Map<Integer, T> results,
            Map<Integer, Double> groundTruth);
}

/**
 * This is example of an evaluator, metric Kendall Tau-B. Don't bother with
 * semantics, all that matters is that I want to be able to call
 * r1.compareTo(r2) for every (r1, r2) that appear in Map<Integer, T> results.
 */
class KendallTauB implements IEvaluator {
    @Override
    public <T extends Comparable<T>> double evaluate(Map<Integer, T> results,
            Map<Integer, Double> groundTruth) {
        int concordant = 0, discordant = 0, tiedRanks = 0, tiedCapabilities = 0;

        for (Entry<Integer, T> rank1 : results.entrySet()) {
            for (Entry<Integer, T> rank2 : results.entrySet()) {
                if (rank1.getKey() < rank2.getKey()) {
                    final T r1 = rank1.getValue();
                    final T r2 = rank2.getValue();
                    final Double c1 = groundTruth.get(rank1.getKey());
                    final Double c2 = groundTruth.get(rank2.getKey());

                    final int ranksDiff = r1.compareTo(r2);
                    final int actualDiff = c1.compareTo(c2);

                    if (ranksDiff * actualDiff > 0) {
                        concordant++;
                    } else if (ranksDiff * actualDiff < 0) {
                        discordant++;
                    } else {
                        if (ranksDiff == 0)
                            tiedRanks++;

                        if (actualDiff == 0)
                            tiedCapabilities++;
                    }
                }
            }
        }

        final double n = results.size() * (results.size() - 1d) / 2d;

        return (concordant - discordant)
                / Math.sqrt((n - tiedRanks) * (n - tiedCapabilities));
    }
}

/**
 * The simulator class that queries the producer and them conveys results to the
 * evaluator.
 */
public class Simulator {
    public static void main(String[] args) {
        // example of a ground truth
        Map<Integer, Double> groundTruth = new HashMap<Integer, Double>();
        groundTruth.put(1, 1d);
        groundTruth.put(2, 2d);
        groundTruth.put(3, 3d);

        // dynamically load producers
        List<IProducer<?>> producerImplementations = lookUpProducers();

        // dynamically load evaluators
        List<IEvaluator> evaluatorImplementations = lookUpEvaluators();

        // pick a producer
        IProducer<?> producer = producerImplementations.get(0);

        // pick an evaluator
        IEvaluator evaluator = evaluatorImplementations.get(0);

        // evaluate the result against the ground truth
        double score = evaluator.evaluate(producer.getResults(), groundTruth);

        System.out.printf("Score is %.2f\n", score);
    }

    // Methods below are for demonstration purposes only. I'm actually using
    // ServiceLoader.load(Clazz) to dynamically discover and load classes that
    // implement interfaces IProducer and IEvaluator
    public static List<IProducer<?>> lookUpProducers() {
        List<IProducer<?>> producers = new ArrayList<IProducer<?>>();
        producers.add(new ProducerA());
        producers.add(new ProducerB());

        return producers;
    }

    public static List<IEvaluator> lookUpEvaluators() {
        List<IEvaluator> evaluators = new ArrayList<IEvaluator>();
        evaluators.add(new KendallTauB());

        return evaluators;
    }
}