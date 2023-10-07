package lotto.domain;

public enum InvalidMessage {
    PURCHASE_IS_NOT_NUMBER("구입 금액이 수가 아닙니다."),
    PURCHASE_IS_ZERO("0원보다 큰 금액을 입력해주세요."),
    PURCHASE_IS_NOT_DIVIDED_BY_THOUSAND("금액은 1,000원 단위로 입력해주세요."),
    LOTTO_NUMBER_IS_NOT_NUMBER("입력한 로또 번호에 수가 아닌 값이 포함되어 있습니다."),
    LOTTO_NUMBER_IS_NOT_IN_RANGE("1 ~ 45사이의 수를 입력해주세요."),
    LOTTO_NUMBER_IS_DUPLICATED("서로 다른 수를 입력해주세요."),
    LOTTO_NUMBER_LENGTH_IS_NOT_SIX("6개의 수를 입력해주세요."),
    BONUS_NUMBER_IS_NOT_NUMBER("입력한 보너스 번호가 수가 아닌 값입니다."),
    BONUS_NUMBER_IS_NOT_IN_RANGE("1 ~ 45사이의 수를 입력해주세요."),
    BONUS_NUMBER_IS_NOT_UNIQUE("로또 번호와 중복된 값을 입력했습니다.");

    private static final String ERROR = "[ERROR] ";
    private final String errorMessage;

    InvalidMessage(String message) {
        errorMessage = ERROR + message;
    }

    public String getErrorMessage(){
        return errorMessage;
    }
}
