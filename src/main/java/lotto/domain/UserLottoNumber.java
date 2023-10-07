package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserLottoNumber {
    private static final int LOTTO_FIRST_NUMBER = 1;
    private static final int LOTTO_LAST_NUMBER = 45;
    private static final int LOTTO_GAME_NUMBER_SIZE = 6;
    private final List<List<Integer>> userLotto = new ArrayList<>();
    private final int gameNumber;
    private UserMoney userMoney;

    public UserLottoNumber(){
        gameNumber = userMoney.getLottoGameNumber();
        setUserLottoNumber(gameNumber);
    }

    public List<List<Integer>> getUserLottoNumber(){
        return userLotto;
    }

    private void setUserLottoNumber(int gameNumber){
        for(int i = 0; i < gameNumber; i++){
            userLotto.add(sortNumbers(generateRandomNumbers()));
        }
    }

    private List<Integer> sortNumbers(List<Integer> numbers){
        return numbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }
    private List<Integer> generateRandomNumbers(){
        return Randoms.pickUniqueNumbersInRange(LOTTO_FIRST_NUMBER,
                LOTTO_LAST_NUMBER, LOTTO_GAME_NUMBER_SIZE);
    }
}
