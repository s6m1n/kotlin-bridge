package bridge.view

import bridge.util.Validator.validateBridgeSize
import camp.nextstep.edu.missionutils.Console
import java.util.IllegalFormatException

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
class InputView {
    /**
     * 다리의 길이를 입력받는다.
     */
    fun readBridgeSize(): Int {
        return try {
            val number = Console.readLine()
            validateBridgeSize(number)
            number.toInt()
        } catch (error: IllegalArgumentException) {
            println(error.message)
            readBridgeSize()
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    fun readMoving(): String {
        return ""
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    fun readGameCommand(): String {
        return ""
    }
}
