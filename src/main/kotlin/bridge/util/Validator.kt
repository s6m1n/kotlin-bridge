package bridge.util

object Validator {
    fun validateBridgeSize(size: String): String {
        return try {
            require(size.toInt() in (3..20)) { "[ERROR] 3 이상 20 이하의 정수를 입력해주세요" }
            size
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("[ERROR] 입력값이 숫자가 아닙니다")
        }
    }
}