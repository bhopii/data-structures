package org.bhopii.ds.arrays;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class Parallel {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		List<Integer> nums = Arrays.asList(1, 2, 3, 4,5, 6, 7, 8);
		sumOfFactorials(nums);
		listOfFactorials(nums);

	}

	private static void sumOfFactorials(List<Integer> numbers) throws InterruptedException, ExecutionException {
		List<CompletableFuture<Integer>> futuresList = numbers.stream()
				.map(number -> CompletableFuture.supplyAsync(() -> addFun1(number))).collect(Collectors.toList());

		CompletableFuture<Void> allFutures = CompletableFuture
				.allOf(futuresList.toArray(new CompletableFuture[futuresList.size()]));

		CompletableFuture<List<Integer>> allCompletableFuture = allFutures.thenApply(future -> {
			return futuresList.stream().map(completableFuture -> completableFuture.join()).collect(Collectors.toList());
		});

		CompletableFuture<List<Integer>> completableFuture = allCompletableFuture.toCompletableFuture();

		List<Integer> finalList = (List<Integer>) completableFuture.get();
		System.out.println(finalList);

	}
	
	private static void listOfFactorials(List<Integer> numbers) throws InterruptedException, ExecutionException {
		List<CompletableFuture<Long>> futuresList = numbers.stream()
				.map(number -> CompletableFuture.supplyAsync(() -> calculateFactorial(number)))
				.collect(Collectors.toList());

		CompletableFuture<Void> allFutures = CompletableFuture
				.allOf(futuresList.toArray(new CompletableFuture[futuresList.size()]));

		CompletableFuture<List<Long>> allCompletableFuture = allFutures.thenApply(future -> {
			return futuresList.stream()
					.map(completableFuture -> completableFuture.join())
					.collect(Collectors.toList());
		});

		CompletableFuture<List<Long>> completableFuture = allCompletableFuture.toCompletableFuture();

		List<Long> finalList = (List<Long>) completableFuture.get();
		
		System.out.println(finalList);
		System.out.println(finalList.stream().reduce((a, b) -> a + b).get());

	}

	private static Long calculateFactorial(int i) {
		if (i >= 20) {
			return 0l;
		} else {
			return LongStream.rangeClosed(1, i).parallel().reduce((a, b) -> a * b).getAsLong();
		}
	}

	public static Integer addFun1(int a) {
		return a + 10;

	}
}
