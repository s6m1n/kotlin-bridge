package bridge.util

object Validator {
    fun validateBridgeSize(size: String): Int {
        return try {
            require(size.toInt() in (3..20)) { "[ERROR] 3 이상 20 이하의 정수를 입력해주세요" }
            size.toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("[ERROR] 입력값이 숫자가 아닙니다")
        }
    }

    fun validateMovingPlace(movingPlace: String): String {
        require(movingPlace == "U" || movingPlace == "D") { "[ERROR] U 또는 D만 입력해주세요" }
        return movingPlace
    }
    fun validateRetryCommand(retryCommand: String): String {
        require(retryCommand == "Q" || retryCommand == "R") { "[ERROR] Q 또는 R만 입력해주세요" }
        return retryCommand
    }
}