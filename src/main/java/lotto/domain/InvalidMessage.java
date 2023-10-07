package lotto.domain;

public enum InvalidMessage {
    PURCHASE_IS_NOT_NUMBER("구입 금액이 수가 아닙니다."),
    PURCHASE_IS_ZERO("0원보다 큰 금액을 입력해주세요."),
    PURCHASE_IS_NOT_DIVIDED_BY_THOUSAND("금액은 1,000원 단위로 입력해주세요.");

    private static final String ERROR = "[ERROR] ";
    private final String errorMessage;

    InvalidMessage(String message) {
        errorMessage = ERROR + message;
    }

    public String getErrorMessage(){
        return errorMessage;
    }
}
