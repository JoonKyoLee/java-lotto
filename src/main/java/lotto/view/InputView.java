package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import lotto.domain.InvalidMessage;

public class InputView {
    private static final String INPUT_MONEY_MESSAGE = "구입금액을 입력해 주세요.\n";
    private static final String INPUT_WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.\n";
    private static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.\n";

    public static int enterMoney(){
        System.out.println(INPUT_MONEY_MESSAGE);
        return convertMoney(Console.readLine());
    }

    public static String enterWinningNumber(){
        System.out.println(INPUT_WINNING_NUMBER_MESSAGE);
        return Console.readLine();
    }

    public static String enterBonusNumber(){
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
        return Console.readLine();
    }

    private static int convertMoney(String money){
        if(!isNumber(money)){
            throw new IllegalArgumentException(InvalidMessage.PURCHASE_IS_NOT_NUMBER.getErrorMessage());
        }
        return Integer.parseInt(money);
    }

    private static boolean isNumber(String moneyString){
        return moneyString.chars().allMatch(Character::isDigit);
    }
}
