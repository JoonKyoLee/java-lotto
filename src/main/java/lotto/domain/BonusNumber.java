package lotto.domain;

public class BonusNumber {
    private static final int BONUS_NUMBER_SIZE = 1;
    private static final int BONUS_FIRST_NUMBER = 1;
    private static final int BONUS_LAST_NUMBER = 45;
    private final int bonus;

    public BonusNumber(int number, Lotto lotto){
        validate(number, lotto);
        bonus = number;
    }

    public int getBonusNumber(){
        return bonus;
    }

    private void validate(int number, Lotto lotto){
        if(!isInRange(number)){
            throw new IllegalArgumentException(InvalidMessage.BONUS_NUMBER_IS_NOT_IN_RANGE.getErrorMessage());
        }
        else if(hasDuplicatedNumber(number, lotto)){
            throw new IllegalArgumentException(InvalidMessage.BONUS_NUMBER_IS_NOT_UNIQUE.getErrorMessage());
        }
    }

    private boolean isInRange(int number){
        return BONUS_FIRST_NUMBER <= number && number <= BONUS_LAST_NUMBER;
    }

    private boolean hasDuplicatedNumber(int number, Lotto lotto){
        return lotto.getNumbers().contains(number);
    }
}
