package org.wordcount.custom.factory;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.wordcount.custom.model.Word;

public class WordCountConfig {

	private static Pattern pattern;
	private static Matcher matcheds;

	private static WordCountConfig instance = new WordCountConfig();

	public static WordCountConfig newInstance() {
		return instance;

	}

	public Word wordContainerInString(String searchWord, String word) {
		int count = 0;
		pattern = Pattern.compile(searchWord);
		matcheds = pattern.matcher(word);

		while (matcheds.find()) {
			count++;
		}
		return new Word(count, searchWord);
	}

	public Word wordContainerInArray(String word, String[] words) {
		int count = 0;
		String search = "";

		for (String str : words) {
			search += str;
		}

		pattern = Pattern.compile(word);
		matcheds = pattern.matcher(search);

		while (matcheds.find()) {
			count++;
		}
		return new Word(count, word);
	}

	public Word wordContainerInList(String word, List<String> words) {
		String search = "";
		int count = 0;
		for (String str : words) {
			search += str;
		}

		pattern = Pattern.compile(word);
		matcheds = pattern.matcher(search);

		while (matcheds.find()) {
			count++;
		}
		return new Word(count, word);
	}


	public Word findword(String word, List<String> list) {
		long count = list.stream().filter(n -> n.equalsIgnoreCase(word)).count();
		return new Word((int) count, word);
	}
	
	
	public Word findCharactor(char c, String word) {
		long count = word.chars().filter(p -> p == c).count();

		return new Word((int) count, word, c);
	}


	
	public  LinkedHashMap<String, Long> countByWordSorted(List<String> list) {
		//collect each words and count them
		Map<String, Long> collect = list.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		
		//sort the values by number of occurrences
		LinkedHashMap<String, Long> countByWordSorted = collect.entrySet().stream()
				.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (v1, v2) -> {
					throw new IllegalStateException();
				}, LinkedHashMap::new));
		
		return countByWordSorted;
	}
	public static void main(String[] args) {
		System.out.println(getRandom());
	}
	public static String getRandom() {
		return "RP".concat(generateRondomCharactors("ABCDEFGHIJKLM12345abcdefghijklNOPQRSTUVWXYZmnopqrstuvwxyz67890", 7));
	}
	
	private static String generateRondomCharactors(String charactorStore, int length) {
		SecureRandom ran = new SecureRandom();		
		return IntStream.range(0, length).mapToObj(i->String.valueOf(charactorStore.charAt(ran.nextInt(charactorStore.length())))).collect(Collectors.joining());
		
	}
}
