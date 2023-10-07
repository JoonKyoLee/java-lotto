package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import lotto.domain.InvalidMessage;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private static final String INPUT_MONEY_MESSAGE = "구입금액을 입력해 주세요.\n";
    private static final String INPUT_WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.\n";
    private static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.\n";
    private static final String LOTTO_INPUT_COMPARATOR = ",";

    public static int enterMoney(){
        System.out.println(INPUT_MONEY_MESSAGE);
        return convertMoney(Console.readLine());
    }

    public static List<Integer> enterWinningNumber(){
        System.out.println(INPUT_WINNING_NUMBER_MESSAGE);
        return convertLottoNumber(Console.readLine());
    }

    public static int enterBonusNumber(){
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
        return convertBonusNumber(Console.readLine());
    }

    private static int convertMoney(String money){
        if(!isNumberMoney(money)){
            throw new IllegalArgumentException(InvalidMessage.PURCHASE_IS_NOT_NUMBER.getErrorMessage());
        }
        return Integer.parseInt(money);
    }

    private static boolean isNumberMoney(String moneyString){
        return moneyString.chars().allMatch(Character::isDigit);
    }

    private static List<Integer> convertLottoNumber(String lotto){
        if(!isNumberLotto(lotto)){
            throw new IllegalArgumentException(InvalidMessage.LOTTO_NUMBER_IS_NOT_NUMBER.getErrorMessage());
        }
        return Arrays.stream(lotto.split(LOTTO_INPUT_COMPARATOR))
                .map(s -> Integer.parseInt(s))
                .collect(Collectors.toList());
    }

    private static boolean isNumberLotto(String lotto){
        return Arrays.stream(lotto.split(LOTTO_INPUT_COMPARATOR))
                .allMatch(number -> number.chars().allMatch(Character::isDigit));
    }

    private static int convertBonusNumber(String bonus){
        if(!isNumberBonus(bonus)){
            throw new IllegalArgumentException(InvalidMessage.BONUS_NUMBER_IS_NOT_NUMBER.getErrorMessage());
        }
        return Integer.parseInt(bonus);
    }

    private static boolean isNumberBonus(String bonus){
        return bonus.chars().allMatch(Character::isDigit);
    }
}
