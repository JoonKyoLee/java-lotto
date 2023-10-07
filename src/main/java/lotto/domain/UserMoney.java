package lotto.domain;

public class UserMoney {
    private static final int THOUSAND = 1000;
    private static final int ZERO = 0;
    private final int money;
    private final int lottoGameNumber;


    public UserMoney(int moneyInput){
        money = moneyInput;
        validate();
        lottoGameNumber = calculateLottoGameNumber();
    }

    public int getMoney(){
        return money;
    }

    public int getLottoGameNumber(){
        return lottoGameNumber;
    }

    private void validate(){
        if(isZero()){
            throw new IllegalArgumentException(InvalidMessage.PURCHASE_IS_ZERO.getErrorMessage());
        }
        else if(!isDividedByThousand()){
            throw new IllegalArgumentException(InvalidMessage.PURCHASE_IS_NOT_DIVIDED_BY_THOUSAND.getErrorMessage());
        }
    }

    private boolean isZero(){
        return money == ZERO;
    }

    private boolean isDividedByThousand(){
        return money % THOUSAND == ZERO;
    }

    private int calculateLottoGameNumber(){
        return money / THOUSAND;
    }
}
