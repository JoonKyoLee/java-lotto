package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private static final int LOTTO_NUMBER_SIZE = 6;
    private static final int LOTTO_FIRST_NUMBER = 1;
    private static final int LOTTO_LAST_NUMBER = 45;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers(){
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        if (!hasSixNumbers(numbers)) {
            throw new IllegalArgumentException(InvalidMessage.LOTTO_NUMBER_LENGTH_IS_NOT_SIX.getErrorMessage());
        }
        else if(!hasInRange(numbers)) {
            throw new IllegalArgumentException(InvalidMessage.LOTTO_NUMBER_IS_NOT_IN_RANGE.getErrorMessage());
        }
        else if(hasDuplicatedNumber(numbers)){
            throw new IllegalArgumentException(InvalidMessage.LOTTO_NUMBER_IS_DUPLICATED.getErrorMessage());
        }
    }

    private boolean hasSixNumbers(List<Integer> numbers){
        return numbers.size() == LOTTO_NUMBER_SIZE;
    }

    private boolean hasInRange(List<Integer> numbers){
        return numbers.stream()
                .filter(number -> LOTTO_FIRST_NUMBER < number && number < LOTTO_LAST_NUMBER)
                .count() == LOTTO_NUMBER_SIZE;
    }

    private boolean hasDuplicatedNumber(List<Integer> numbers){
        return numbers.stream()
                .distinct()
                .count() != LOTTO_NUMBER_SIZE;
    }
}
