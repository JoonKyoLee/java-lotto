package lotto.domain;

public class BonusNumber {
    private static final int BONUS_FIRST_NUMBER = 1;
    private static final int BONUS_LAST_NUMBER = 45;
    private final int bonus;
    private Lotto lotto;

    public BonusNumber(int number){
        validate(number);
        bonus = number;
    }

    public int getBonusNumber(){
        return bonus;
    }

    private void validate(int number){
        if(!isInRange(number)){
            throw new IllegalArgumentException(InvalidMessage.BONUS_NUMBER_IS_NOT_IN_RANGE.getErrorMessage());
        }
        else if(hasDuplicatedNumber(number)){
            throw new IllegalArgumentException(InvalidMessage.BONUS_NUMBER_IS_NOT_UNIQUE.getErrorMessage());
        }
    }

    private boolean isInRange(int number){
        return BONUS_FIRST_NUMBER <= number && number <= BONUS_LAST_NUMBER;
    }

    private boolean hasDuplicatedNumber(int number){
        return lotto.getNumbers().contains(number);
    }
}
