package bridge.view

import bridge.util.Constant.FAIL
import bridge.util.Constant.FINAL_RESULT
import bridge.util.Constant.GAME_START_MESSAGE
import bridge.util.Constant.INPUT_BRIDGE_SIZE_MESSAGE
import bridge.util.Constant.INPUT_MOVE_COMMAND_MESSAGE
import bridge.util.Constant.INPUT_RETRY_COMMAND_MESSAGE
import bridge.util.Constant.IS_SUCCESS
import bridge.util.Constant.SUCCESS
import bridge.util.Constant.TOTAL_TRIAL

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
class OutputView {

    fun printStartMessage() {
        println(GAME_START_MESSAGE)
    }

    fun printInputBridgeSizeMessage() {
        println(INPUT_BRIDGE_SIZE_MESSAGE)
    }

    fun printChoiceMovingPlace() {
        println(INPUT_MOVE_COMMAND_MESSAGE)
    }

    fun printRetry() {
        println(INPUT_RETRY_COMMAND_MESSAGE)
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printMap(bridgeResultString: List<String>) {
        bridgeResultString.forEach { bridge ->
            bridge.forEach { print(it) }
            println()
        }
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printResult(isSuccess: Boolean, bridgeResultString: List<String>, round: Int) {
        println(FINAL_RESULT)
        printMap(bridgeResultString)

        println(IS_SUCCESS + "${booleanToString(isSuccess)}")
        println(TOTAL_TRIAL + "$round")
    }

    private fun booleanToString(boolean: Boolean): String {
        return when (boolean) {
            true -> SUCCESS
            false -> FAIL
        }
    }
}
