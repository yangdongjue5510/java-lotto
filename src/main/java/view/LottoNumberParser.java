package view;

import static java.util.stream.Collectors.toList;

import java.util.List;

public class LottoNumberParser {
    private static final String REGEX_DELIMITER = ",";
    private static final String REGEX_LOTTO_NUMBER_FORMAT = "^\\s*[0-9]{1,2}\\s*(\\s*,\\s*[0-9]{1,2}\\s*){5}$";
    static final String INVALID_LOTTO_NUMBER_FORMAT_MESSAGE = "당첨 번호는 반드시 6개의 숫자여야 합니다.";

    public List<Integer> parse(String numbers) {
        if (!numbers.matches(REGEX_LOTTO_NUMBER_FORMAT)) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_FORMAT_MESSAGE);
        }
        return parseToLottoNumbers(numbers);
    }

    private List<Integer> parseToLottoNumbers(String numbers) {
        List<String> tokens = splitNumbers(numbers);
        List<String> trimNumbers = trimNumbers(tokens);
        List<Integer> intNumbers = toInts(trimNumbers);
        return intNumbers;
    }


    private List<String> splitNumbers(String numbers) {
        return List.of(numbers.split(REGEX_DELIMITER));
    }

    private List<String> trimNumbers(List<String> numbers) {
        return numbers.stream()
            .map(String::trim)
            .collect(toList());
    }

    private List<Integer> toInts(List<String> numbers) {
        return numbers.stream()
                .map(Integer::valueOf)
                .collect(toList());
    }

}
